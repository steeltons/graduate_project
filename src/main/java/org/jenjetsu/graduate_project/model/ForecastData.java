package org.jenjetsu.graduate_project.model;

import java.math.*;
import java.time.*;
import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.entity.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForecastData {

    private UUID ffwiId;

    private String ffwiName;

    private BigDecimal previousComplexIndicator;

    private LocalDate previousComplexDate;

    private List<FFWIParameter> weatherDataParams;

}
