package com.joandkim.greenery.dto.plant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlantCard {
    private String imageUrl;
    private String title;
    private String description;
    private String growthForm;
}
