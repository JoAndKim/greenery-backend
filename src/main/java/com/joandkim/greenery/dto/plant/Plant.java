package com.joandkim.greenery.dto.plant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class Plant {
    private String cntntsNo;
    private String cntntsSj;
    private String rtnFileCours;
    private String rtnFileSeCode;
    private String rtnFileSn;
    private String rtnImageDc;
    private String rtnImgSeCode;
    private String rtnOrginlFileNm;
    private String rtnStreFileNm;
    private String rtnThumbFileNm;
}
