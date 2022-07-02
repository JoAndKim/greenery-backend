package com.joandkim.greenery.dto.plant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PlantCard {
    private String imageUrl;
    private String title;
    private String description;
    private String growthForm;

    public static PlantCard from(Plant plant) {
        return PlantCard.builder()
                .imageUrl("http://www.nongsaro.go.kr/cms_contents/301" + "/" + (plant.getRtnStreFileNm().split("\\|"))[0])
                .title(plant.getCntntsSj())
                .growthForm((plant.getRtnImageDc().split("\\|"))[0])
                .description("test")
                .build();
    }
}
