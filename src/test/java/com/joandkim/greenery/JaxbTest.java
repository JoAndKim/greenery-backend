//package com.joandkim.greenery;
//
//import com.joandkim.greenery.dto.plant.RootPlantRequest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.URI;
//
//public class JaxbTest {
//
//    @Autowired
//    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
//
//    @Test
//    @DisplayName("unmarshal")
//    public void jaxbTest() throws JAXBException, IOException {
//
//        // Given
//        FileInputStream fileInputStream = new FileInputStream("response.xml");
//        JAXBContext jaxbContext = JAXBContext.newInstance(RootPlantRequest.class);
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//        // When
//        RootPlantRequest xmlListTag = (RootPlantRequest) unmarshaller.unmarshal(fileInputStream);
//        fileInputStream.close();
//
//        // Then
//        log.info("xmlListTag: {}", xmlListTag);
//    }
//
//    @Test
//    @DisplayName("resttemplate 테스트")
//    void restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        URI uri = UriComponentsBuilder
//                .fromHttpUrl("http://api.nongsaro.go.kr/service/garden/gardenList?apiKey=20220622GJGATKBLYJ5GA5OK4Q247W")
//                .encode()
//                .build()
//                .toUri();
//        ResponseEntity<RootPlantRequest> response = restTemplate.exchange(uri, HttpMethod.POST, null, RootPlantRequest.class);
//
//        log.info("response: {}", response);
//    }
//}
