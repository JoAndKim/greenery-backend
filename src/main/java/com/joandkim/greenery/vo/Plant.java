package com.joandkim.greenery.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class Plant {
    private Integer id;
    private String name;
    private String imageUrl;
    private Integer group;
    private Integer brightness;
    private Integer competence;
    private String content;
    private String technicalName;
    private String watering;
    private String humidity;
    private String illuminance;
}
