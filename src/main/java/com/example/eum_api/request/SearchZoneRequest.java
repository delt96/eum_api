package com.example.eum_api.request;

import lombok.Data;

@Data
public class SearchZoneRequest {
    String id;
    String key;
    String areaCd;
    String type ="S";
    String uname;
}
