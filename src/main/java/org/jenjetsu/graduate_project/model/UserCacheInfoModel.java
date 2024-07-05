package org.jenjetsu.graduate_project.model;

import java.time.*;
import java.util.*;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCacheInfoModel {

    private UUID registrationCode;

    private ZonedDateTime expiredAt;

    private Long roleId;

}
