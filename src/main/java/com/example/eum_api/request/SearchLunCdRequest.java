package com.example.eum_api.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Data
@Builder
public class SearchLunCdRequest {
    String key;
    String id;
    String landUseNm;
    String pageNo;

    public SearchLunCdRequest(String key, String id, String landUseNm, String pageNo) {
        this.key = key;
        this.id = id;
        this.landUseNm = landUseNm;
        this.pageNo = pageNo;
    }
}
