package com.seller.helper.sellerhelper.dto;

import lombok.Data;

@Data
public class SearchResultDTO {
    private String keyword;     // 키워드
    private int shopCnt;        // 총 등록 건수
    private int searchCnt;      // 월간 검색 건수
    private double clickCnt;    // 월간 평균 클릭수
    private double clickRate;   // 월간 평균 클릭률
    private double adCount;     // 광고 노출수
    private String compIdx;     // 경쟁강도
    private double rate;        // 검색 경쟁률
}
