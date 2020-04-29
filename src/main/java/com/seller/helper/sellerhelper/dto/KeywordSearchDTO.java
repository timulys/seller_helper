package com.seller.helper.sellerhelper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KeywordSearchDTO {
    private String accLicense;
    private String secretKey;
    private String customerId;
    private String keyword;
}
