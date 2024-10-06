package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Zone {
    String ucode;
    String uname;
    String lawCd;
    String lawNm;

    public Zone(String ucode, String uname, String lawCd, String lawNm) {
        this.ucode = ucode;
        this.uname = uname;
        this.lawCd = lawCd;
        this.lawNm = lawNm;
    }
}
