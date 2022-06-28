package com.joandkim.greenery;

import com.joandkim.greenery.dto.plant.RootPlantRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.IOException;

public class JaxbTest {

    @Test
    @DisplayName("unmarshal 테스트")
    public void jaxbTest() throws JAXBException, IOException {

        // Given
        FileInputStream fileInputStream = new FileInputStream("response.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(RootPlantRequest.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // When
        RootPlantRequest xmlListTag = (RootPlantRequest) unmarshaller.unmarshal(fileInputStream);
        fileInputStream.close();

        // Then
        System.out.println(xmlListTag);
    }
}
