package com.seller.helper.sellerhelper.domain;

import com.seller.helper.sellerhelper.domain.enums.Role;
import com.seller.helper.sellerhelper.dto.MemberDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
// BaseDomain extends
// 사용자
public class Member {
    //
    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long id;
    private String loginId;     // 사용자 Login ID
    private String password;    // 사용자 패스워드
    private String name;        // 사용자 이름
    private String email;       // 사용자 이메일
    private String accLicense;  // 광고 API 리어선스
    private String secretKey;   // 광고 API 비밀키

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String loginId, String password, String name, String email,
              String accLicense, String secretKey, Role role) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.accLicense = accLicense;
        this.secretKey = secretKey;
        this.role = role;
    }

    public static Member toEntity(MemberDto dto) {
        return Member.builder().loginId(dto.getLoginId())
                .password(dto.getPassword())
                .name(dto.getName())
                .email(dto.getEmail())
                .accLicense(dto.getAccLicense())
                .secretKey(dto.getSecretKey())
                .build();
    }
}
