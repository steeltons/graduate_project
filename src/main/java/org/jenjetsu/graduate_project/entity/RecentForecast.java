package org.jenjetsu.graduate_project.entity;

import java.math.*;
import java.time.*;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recent_forecast")
public class RecentForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ffwi_id")
    private FFWI ffwi;

    @Column(name = "complex_indicator", nullable = false)
    private BigDecimal complexIndicator;

    @Column(name = "forecast_time", nullable = false)
    private ZonedDateTime forecastTime;

}
