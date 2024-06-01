package org.jenjetsu.graduate_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ffwi_parameter")
public class FFWIParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "weather_data_id")
    private WeatherData  weatherData;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ffwi_id")
    private FFWI ffwi;

    @Column(name = "formula_parameter", nullable = false, length = 16)
    @Length(min = 1, max = 16, message = "Длина параметра должна быть в диапазоне от 1 и до 16")
    private String formulaParameter;

    @Column(name = "weather_name", length = 255, nullable = false)
    private String weatherName;

}
