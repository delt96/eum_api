package com.example.eum_api.response;

import lombok.Data;

import java.util.List;

@Data
public class SearchAreaResponse {
    String totalSize;
    List<Area> areaCd;
}
