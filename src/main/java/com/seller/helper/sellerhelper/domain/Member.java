package com.seller.helper.sellerhelper.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Member extends BaseEntity {
    private Long id;
    private String accLicense;      // API 라이선스 키
    private String secretKey;       // API 시크릿 키
}
