package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArLandUseInfoResponse {
    String totalSize;
    ActReg actReg;

    public ArLandUseInfoResponse(String totalSize, ActReg actReg) {
        this.totalSize = totalSize;
        this.actReg = actReg;
    }
}
