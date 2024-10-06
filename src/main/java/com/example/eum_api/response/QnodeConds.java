package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QnodeConds {
    String item ;

    public QnodeConds(String item) {
        this.item = item;
    }
}
