package com.example.eum_api.request;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class SearchAreaRequest {
    String id ;
    String key ;

    @Builder
    public SearchAreaRequest(String id, String key) {
        this.id = id;
        this.key = key;
    }
}
