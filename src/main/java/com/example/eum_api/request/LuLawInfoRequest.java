package com.example.eum_api.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Data
@Builder
public class LuLawInfoRequest {
    String id ;
    String key ;
    String areaCd;
    String ucodeList;

    @Builder
    public LuLawInfoRequest(String id, String key, String areaCd, String ucodeList) {
        this.id = id;
        this.key = key;
        this.areaCd = areaCd;
        this.ucodeList = ucodeList;
    }
}
