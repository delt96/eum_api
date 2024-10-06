package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActReg {
    String uname;
    String ucode;
    String ucodeRefLawCd;
    String getUcodeRefLawNm;
    ActRegList actRegList;
    QnodeCond qnodeCond;

    public ActReg(String uname, String ucode, String ucodeRefLawCd, String getUcodeRefLawNm, ActRegList actRegList, QnodeCond qnodeCond) {
        this.uname = uname;
        this.ucode = ucode;
        this.ucodeRefLawCd = ucodeRefLawCd;
        this.getUcodeRefLawNm = getUcodeRefLawNm;
        this.actRegList = actRegList;
        this.qnodeCond = qnodeCond;
    }
}
