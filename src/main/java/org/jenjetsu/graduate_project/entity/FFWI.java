package org.jenjetsu.graduate_project.entity;

import java.util.UUID;
import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ffwi")
public class FFWI {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    @Length(min = 4, max = 32, message = "Размер строки не подходит")
    @Pattern(regexp = "[а-яА-Я][а-яА-Я\\s]{2,31}", message = "Шаблон строки не совпадает")
    private String name;

    //    @ValidFormula
    @Column(name = "formula", nullable = false, length = 512)
    private String formula;

    @OneToMany(mappedBy = "ffwi", fetch = FetchType.LAZY)
    private Set<FWI> fwiSet;

    @OneToMany(mappedBy = "ffwi", fetch = FetchType.LAZY)
    private Set<FFWIParameter> parameters;

}
