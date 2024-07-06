package org.jenjetsu.graduate_project.service.impl.component;

import java.math.*;
import java.time.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import lombok.*;
import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.model.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.stereotype.*;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class ForecastCalculatorComponent {

    private static final UUID RAIN_WEATHER_PARAM_ID
        = UUID.fromString("8b205197-8761-468a-bdd4-0e0538e68ff3");

    private final FormulaCalculatorService calculatorService;

    private final FormulaLexerService lexerService;

    private final FormulaParserService parserService;

    private final Clock systemClock;

    public FFWIForecastResult calculateForecast(
        ForecastDataCalculateDto calculateDto,
        FFWI ffwi
    ) {
        var messageLog = new ArrayList<String>();
        messageLog.add("Дата построения отчёта " + LocalDate.now(systemClock));
        var formulaParams = ffwi.getWeatherDataParams();
        var weatherParams = calculateDto.getWeatherDataParams();
        var resultMap = createFormulaValueMap(weatherParams, formulaParams, messageLog);
        var previousIndex = calculateDto.getPreviousComplexIndicator();

        var calculateResult = calculateByFormula(ffwi.getFormula(), resultMap, messageLog);
        var coeff = getRainCoefficient(weatherParams, ffwi, previousIndex, messageLog);
        calculateResult = calculateResult.add(previousIndex.multiply(coeff));
        messageLog.add("Текущий КП: " + calculateResult);

        var fwi = findFwi(ffwi.getFwiSet(), calculateResult, messageLog);
        var danger = fwi.getFireDanger();
        messageLog.add("Текущий уровень угрозы: " + danger.getName());

        var result = FFWIForecastResult.builder()
            .ffwi(ffwi)
            .complexIndex(calculateResult)
            .fireDanger(danger)
            .messages(messageLog)
            .build();

        return result;
    }

    private Map<String, Object> createFormulaValueMap(
        List<WeatherValueDto> weatherValueDtos,
        Collection<FFWIParameter> ffwiParameters,
        List<String> messageLog
    ) {
        var weatheValueMap = weatherValueDtos.stream()
            .collect(Collectors.toMap(WeatherValueDto::getWeatherDataId, Function.identity()));

        var resultMap = new HashMap<String, Object>();

        ffwiParameters.forEach(parameter -> {
            var value = weatheValueMap.getOrDefault(parameter.getWeatherData().getId(), null);
            resultMap.put(parameter.getFormulaParameter(), value.getValue());
            messageLog.add(parameter.getWeatherName() + " " + value.getValue());
        });

        return resultMap;
    }

    private BigDecimal calculateByFormula(
        String formula,
        Map<String, Object> params,
        List<String> messageLog
    ) {
        var lexems = lexerService.parseFormula(formula);
        var formulaTree = parserService.parse(lexems);
        var finalIndex = calculatorService.calculate(formulaTree, params);

        messageLog.add("Значение по формуле: " + finalIndex);

        return finalIndex;
    }

    private BigDecimal getRainCoefficient(
        List<WeatherValueDto> values,
        FFWI ffwi,
        BigDecimal previousIndex,
        List<String> messageLog
    ) {
        var rainParam = values.stream()
            .filter(value -> value.getWeatherDataId().equals(RAIN_WEATHER_PARAM_ID))
            .findFirst()
            .get();

        var precipitationRecord = ffwi.getPrecipitationRecords().stream()
            .filter(record -> previousIndex.compareTo(record.getMinValue()) >= 0
                              && previousIndex.compareTo(record.getMaxValue()) <= 0)
            .findFirst().get();

        var rainBorder = precipitationRecord.getValue();
        BigDecimal coeff = null;

        if (rainBorder.compareTo(rainParam.getValue().intValue()) <= 0) {
            messageLog.add(
                "Коэффициент осадков = 0 т.к. дневные осадки больше максимального " +
                "допустимого значения " + rainBorder);
            coeff = BigDecimal.ZERO;
        } else {
            messageLog.add("Коэффициент осадков = 1 т.к. дневные осадки не превышают допустимое " +
                           "значение " + rainBorder);
            coeff = BigDecimal.ONE;
        }

        return coeff;
    }

    private FWI findFwi(Collection<FWI> fwis, BigDecimal currentIndex, List<String> messageLog) {
        final var badMessage = "Класс %s не подходит т.к. значение КП %s не находится в границах класса [%s;%s]";
        final var goodMessage = "Класс %s подходит т.к. значение КП %s находится в границах класса [%s;%s]";

        var result = fwis.stream()
            .filter(fwi -> {
                var predicateResult = currentIndex.compareTo(fwi.getMinValue()) >= 0
                                      && currentIndex.compareTo(fwi.getMaxValue()) <= 0;
                if (!predicateResult) {
                    messageLog.add(format(badMessage, fwi.getName(), currentIndex, fwi.getMinValue(), fwi.getMaxValue()));
                }
                return predicateResult;
            })
            .findFirst()
            .get();

        messageLog.add(format(goodMessage, result.getName(), currentIndex, result.getMinValue(),
            result.getMaxValue()));

        return result;
    }

}
