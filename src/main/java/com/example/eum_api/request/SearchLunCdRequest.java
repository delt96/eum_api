package com.example.eum_api.request;

import lombok.Data;

@Data
public class SearchLunCdRequest {
    String key;
    String id;
    String landUseNm;
    String pageNo;
}
