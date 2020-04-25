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
// BaseDomain extends
// 사용자
public class User {
    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long id;
    private String loginId;     // 사용자 Login ID
    private String password;    // 사용자 패스워드
    private String userName;    // 사용자 이름
    private String accLicense;  // 광고 API 리어선스
    private String secretKey;   // 광고 API 비밀키
}
