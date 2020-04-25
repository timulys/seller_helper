package com.seller.helper.sellerhelper.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue
    Long id;
    private String loginId;
    private String password;
    private String userName;
    private String accLicense;
    private String secretKey;
}
