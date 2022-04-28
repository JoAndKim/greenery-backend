package com.joandkim.greenery.controller;

import com.joandkim.greenery.dto.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/api/image")
    public ResponseEntity<Image> image(@RequestParam("imageFile") MultipartFile multipartFile) {
        logger.info("multipartFile: {}", multipartFile);
        return ResponseEntity.ok(new Image());
    }
}
