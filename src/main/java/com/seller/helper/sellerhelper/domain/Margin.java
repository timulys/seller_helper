package com.seller.helper.sellerhelper.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Margin {
    // Origin Prices
    private int originPrice;        // 원 상품 구매가(부가세포함)
    private int originShipping;     // 원 상품 택배비
    private int buyCnt;             // 총 구매 수량

    // Seller Prices
    private int sellPrice;          // 셀러 판매가
    private int sellShipping;       // 셀러 배송비
    private int setMarginRate;      // 마진률 설정
    private int setMarginPrice;     // 마진금액 설정
    private int otherFee;           // 기타부대비용(포장,스티커,박스테이프 등)
    private double platformFee;     // 플랫폼 수수료

    // OVERSEAS Prices
    private double exchangeRate;    // 구매대행 환율
    private int exchangeShipping;   // 구매대행 배대지 물류비용(재패키징, 기타 배대지 비용 모두 추가)
    private int customsDuties;      // 통관세 금액
}
