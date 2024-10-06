package com.example.eum_api.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EumLaw {
    @JacksonXmlProperty(localName = "UCODE")
    String UCODE;
    @JacksonXmlProperty(localName = "UNAME")
    String UNAME;
    @JacksonXmlProperty(localName = "LAW_CONTENTS")
    String LAW_CONTENTS;
    @JacksonXmlProperty(localName = "LAW_LEVEL")
    String LAW_LEVEL;
    @JacksonXmlProperty(localName = "LAW_FULL_CD")
    String LAW_FULL_CD;

}
