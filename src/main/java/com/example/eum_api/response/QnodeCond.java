package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QnodeCond {
    String qnodeDesc;
    String rnum;

    public QnodeCond(String qnodeDesc, String rnum) {
        this.qnodeDesc = qnodeDesc;
        this.rnum = rnum;
    }
}
