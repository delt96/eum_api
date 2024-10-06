package com.example.eum_api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchLunCdResponse {
    String totalSize;
    String totalPage;
    String listSize;
    String pageNo;
    Lun lunCd;

    public SearchLunCdResponse(String totalSize, String totalPage, String listSize, String pageNo, Lun lunCd) {
        this.totalSize = totalSize;
        this.totalPage = totalPage;
        this.listSize = listSize;
        this.pageNo = pageNo;
        this.lunCd = lunCd;
    }
}
