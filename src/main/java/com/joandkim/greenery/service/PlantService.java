package com.joandkim.greenery.service;

import com.joandkim.greenery.vo.Plant;
import com.joandkim.greenery.mapper.PlantMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlantService {

    private final PlantMapper plantMapper;

    public List<Plant> getPlants() {
        return plantMapper.getPlants();
    }
}
