package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LuInfoList {
    String nodeDesc;
    String luRefLawNm1;
    String luRefLawNm2;
    String luRefLawNm3;
    String defRef;

    public LuInfoList(String nodeDesc, String luRefLawNm1, String luRefLawNm2, String luRefLawNm3, String defRef) {
        this.nodeDesc = nodeDesc;
        this.luRefLawNm1 = luRefLawNm1;
        this.luRefLawNm2 = luRefLawNm2;
        this.luRefLawNm3 = luRefLawNm3;
        this.defRef = defRef;
    }
}
