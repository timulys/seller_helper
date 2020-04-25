package com.seller.helper.sellerhelper.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Keyword {
    @Id
    @GeneratedValue
    @Column(name = "KEYWORD_ID")
    private Long id;
    private String keyword;     // 사용자 입력 키워드
    private int shopCnt;        // 총 스토어 수(광고 모두 포함) - Naver
    private int monthlyCnt;     // 월간 검색량(Naver Search API)
    private double rate;        // 총 스토어수 / 월간검색량 : 경쟁률
    private double adPrice;     // 광고비 평균(?) - additional information

    // etc information 식별되는대로 추가
}
