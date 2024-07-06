package org.jenjetsu.graduate_project.controller;

import lombok.*;
import org.jenjetsu.graduate_project.client.api.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AppControllerApiImpl implements AppControllerApi {

    private final AppService appService;

    @Override
    public ResponseEntity<Void> apiV1AppEndpointsPost() {
        appService.clearDatabase();

        return ResponseEntity.ok(null);
    }

}
