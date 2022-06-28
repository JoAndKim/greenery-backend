package com.joandkim.greenery.controller;

import com.joandkim.greenery.dto.plant.Plant;
import com.joandkim.greenery.service.PlantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/plants")
public class PlantController {

    private final PlantService plantService;

    public ResponseEntity plants() {
        List<Plant> plants = plantService.getPlants();
        return ResponseEntity.ok(plants);
    }
}
