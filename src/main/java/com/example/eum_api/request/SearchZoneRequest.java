package com.example.eum_api.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Data
public class SearchZoneRequest {
    String id;
    String key;
    String areaCd;
    String type;
    String uname;

    @Builder
    public SearchZoneRequest(String id, String key, String areaCd, String uname) {
        this.id = id;
        this.key = key;
        this.areaCd = areaCd;
        this.type = "S";
        this.uname = uname;
    }
}
