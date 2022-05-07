package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.Image;
import com.joandkim.greenery.util.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final S3Uploader s3Uploader;

    public Image upload(MultipartFile multipartFile) throws IOException {
        String imageUrl = s3Uploader.upload(multipartFile, "static");
        return new Image(imageUrl);
    }

    public void delete(String imageUrl) {
        String[] split = imageUrl.split("/");
        String filename = "static/" + split[split.length - 1];
        log.info("filename: {}", filename);

        //TODO: S3에서 데이터가 실제로 삭제되지 않음
        s3Uploader.delete(filename);
    }
}
