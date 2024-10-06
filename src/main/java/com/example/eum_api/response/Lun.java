package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lun {
    String lunNm;
    String lunCd;
    String rnum;

    public Lun(String lunNm, String lunCd, String rnum) {
        this.lunNm = lunNm;
        this.lunCd = lunCd;
        this.rnum = rnum;
    }
}
