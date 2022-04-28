package com.joandkim.greenery.dto;

import lombok.Getter;

@Getter
public class Image {
    private final String imageUrl;

    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
