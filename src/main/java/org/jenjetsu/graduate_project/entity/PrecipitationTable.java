package org.jenjetsu.graduate_project.entity;

import java.math.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "precipitation_table")
public class PrecipitationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_value", nullable = false)
    @DecimalMin("0.0")
    private BigDecimal minValue;

    @Column(name = "max_value", nullable = false)
    @DecimalMin("0.0")
    private BigDecimal maxValue;

    @Column(name = "value", nullable = false)
    private Integer value;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ffwi_id")
    private FFWI ffwi;

}
