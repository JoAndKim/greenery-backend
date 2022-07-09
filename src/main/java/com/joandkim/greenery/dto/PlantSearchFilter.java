package com.joandkim.greenery.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlantSearchFilter {
    private Integer group;
    private Integer competence;
    private Integer brightness;
}
