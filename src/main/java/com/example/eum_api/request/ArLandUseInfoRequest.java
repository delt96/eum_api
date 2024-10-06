package com.example.eum_api.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@ToString
@Data
@Builder
public class ArLandUseInfoRequest {
    String id;
    String key;
    String ucodeList;
    String landUseNm;
    String areaCd;

    @Builder
    public ArLandUseInfoRequest(String id, String key, String ucodeList, String landUseNm, String areaCd) {
        this.id = id;
        this.key = key;
        this.ucodeList = ucodeList;
        this.landUseNm = landUseNm;
        this.areaCd = areaCd;
    }
}
