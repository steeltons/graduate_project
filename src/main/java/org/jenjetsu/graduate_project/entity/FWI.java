package org.jenjetsu.graduate_project.entity;

import java.math.*;
import java.text.*;
import java.util.UUID;
import java.util.*;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fwi")
public class FWI {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "name", length = 32, nullable = false)
    @Length(min = 4, max = 32, message = "Размер название класса пожарной опасности не подходит")
    private String name;

    @Column(name = "min_value", nullable = false)
    @DecimalMin(value = "0", message = "Нижняя граница не может быть меньше 0")
    @DecimalMax(value = "1.7976931348623157E308", message = "Нижняя граница превышает значение Long")
    private BigDecimal minValue;

    @Column(name = "max_value", nullable = false)
    @DecimalMin(value = "0", message = "Верхняя граница не может быть меньше 0")
    @DecimalMax(value = "1.7976931348623157E308", message = "Верхняя граница превышает значение Long")
    private BigDecimal maxValue;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "ffwi_id")
    private FFWI ffwi;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "fire_danger_id")
    private FireDanger fireDanger;

    public String getMinValueAsString() {
        var df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        return this.minValue.compareTo(new BigDecimal(Double.MAX_VALUE).subtract(new BigDecimal(
            "1000000.0"))) >= 0 ? "∞" : df.format(this.minValue);
    }

    public String getMaxValueAsString() {
        var df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        return this.minValue.compareTo(new BigDecimal(Double.MAX_VALUE).subtract(new BigDecimal(
            "1000000.0"))) >= 0 ? "∞" : df.format(this.minValue);
    }

}
