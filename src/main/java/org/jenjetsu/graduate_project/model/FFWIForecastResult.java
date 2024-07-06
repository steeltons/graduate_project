package org.jenjetsu.graduate_project.model;

import java.math.*;
import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.entity.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FFWIForecastResult {

    private FFWI ffwi;

    private FireDanger fireDanger;

    private BigDecimal complexIndex;

    private List<String> messages;

}
