package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchZoneResponse {
    String totalSize;
    Zone zoneCd;

    public SearchZoneResponse(String totalSize, Zone zoneCd) {
        this.totalSize = totalSize;
        this.zoneCd = zoneCd;
    }
}
