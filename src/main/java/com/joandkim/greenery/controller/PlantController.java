package com.joandkim.greenery.controller;

import com.joandkim.greenery.service.PlantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/plants")
public class PlantController {

    private final PlantService plantService;

    @GetMapping
    public ResponseEntity plants(@RequestParam(required = false) Integer group,
                                 @RequestParam(required = false) Integer competence,
                                 @RequestParam(required = false) Integer brightness) {
        return ResponseEntity.ok(plantService.getPlants(group, competence, brightness));
    }
}
