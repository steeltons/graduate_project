package org.jenjetsu.graduate_project.entity;

import java.util.UUID;

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
@Entity(name = "weather_data")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "name", nullable = false, unique = true, length = 32)
    @Pattern(regexp = "[а-я\s]{4,32}", message = "Название метеоданной не соответствует формату")
    @Length(min = 4, max = 32, message = "Размер название метеоданной не подходит")
    private String name;

}
