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

    public static final BigDecimal INFINITY_VALUE = new BigDecimal("9999999999.99");

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

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "ffwi_id")
    private FFWI ffwi;

}
