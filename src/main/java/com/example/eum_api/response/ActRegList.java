package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActRegList {
    String ActNm;
    String regNm;
    QnodeConds qnodeConds;
    LuInfoList luInfoList;

    public ActRegList(String actNm, String regNm, QnodeConds qnodeConds, LuInfoList luInfoList) {
        ActNm = actNm;
        this.regNm = regNm;
        this.qnodeConds = qnodeConds;
        this.luInfoList = luInfoList;
    }
}
