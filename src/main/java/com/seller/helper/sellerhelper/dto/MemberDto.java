package com.seller.helper.sellerhelper.dto;

import com.seller.helper.sellerhelper.domain.Member;
import lombok.Data;

@Data
public class MemberDto {
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String accLicense;
    private String secretKey;
    private String role;

    public MemberDto toDto(Member entity) {
        MemberDto dto = new MemberDto();
        dto.setLoginId(entity.getLoginId());
        dto.setPassword(entity.getPassword());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setAccLicense(entity.getAccLicense());
        dto.setSecretKey(entity.getSecretKey());
        dto.setRole(entity.getRole().toString());

        return dto;
    }
}
