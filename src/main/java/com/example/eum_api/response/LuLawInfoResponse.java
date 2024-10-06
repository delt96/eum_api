package com.example.eum_api.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
@Data
@JacksonXmlRootElement(localName = "response")
public class LuLawInfoResponse {

    @JacksonXmlProperty(localName = "totalSize")
    String totalSize;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "EumLaw")
    private List<EumLaw> EumLaw;

}
