package org.jenjetsu.graduate_project.client.model;

import java.util.*;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FwiDictionaryReturnDto {

    private List<FFWIResponseDto> ffwiList;

    private List<FireDangerResponseDto> fireDangerList;

}
