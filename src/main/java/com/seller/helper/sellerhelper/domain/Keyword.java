package com.seller.helper.sellerhelper.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Keyword extends BaseEntity {
    private Long id;
    private String keyword;     // 사용자 입력 키워드
    private int shopCnt;        // 총 스토어 수(광고 모두 포함) - Naver
    private int searchCnt;      // 월간 검색량(Naver Search API)
    private double rate;        // 총 스토어수 / 월간검색량 : 경쟁률
    private double adPrice;     // 광고비 평균(?) - additional information

    // etc information 식별되는대로 추가
}
