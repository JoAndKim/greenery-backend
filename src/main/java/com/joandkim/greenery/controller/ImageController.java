package com.joandkim.greenery.controller;

import com.joandkim.greenery.dto.Image;
import com.joandkim.greenery.service.ImageService;
import com.joandkim.greenery.util.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final S3Uploader s3Uploader;
    private final ImageService imageService;

    @PostMapping("/api/image")
    public ResponseEntity<Image> image(@RequestParam("imageFile") MultipartFile multipartFile) throws IOException {
        Image image = imageService.upload(multipartFile);
        return ResponseEntity.ok(image);
    }

    @DeleteMapping("/api/image")
    public ResponseEntity<Void> deleteImage(@RequestBody String imageUrl) {
        imageService.delete(imageUrl);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
