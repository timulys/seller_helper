package com.seller.helper.sellerhelper.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_member")
@ToString
@EqualsAndHashCode
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String accLicense;      // API 라이선스 키
    private String secretKey;       // API 시크릿 키
}
