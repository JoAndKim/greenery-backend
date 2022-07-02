package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.plant.Plant;
import com.joandkim.greenery.dto.plant.PlantCard;
import com.joandkim.greenery.dto.plant.RootPlantRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlantService {
    public List<PlantCard> getPlants() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://api.nongsaro.go.kr/service/garden/gardenList?apiKey=20220622GJGATKBLYJ5GA5OK4Q247W")
                .encode()
                .build()
                .toUri();
        ResponseEntity<RootPlantRequest> response = restTemplate.exchange(uri, HttpMethod.POST, null, RootPlantRequest.class);

        List<Plant> plants = response.getBody().getBodyPlantRequest().getPlantListRequest().getPlants();
        return  plants.stream()
                .map(PlantCard::from)
                .collect(Collectors.toList());
    }
}
