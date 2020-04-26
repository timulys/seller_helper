package com.seller.helper.sellerhelper.service.login;

import com.seller.helper.sellerhelper.domain.Member;
import com.seller.helper.sellerhelper.domain.enums.Role;
import com.seller.helper.sellerhelper.dto.MemberDto;
import com.seller.helper.sellerhelper.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService implements UserDetailsService {

    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        if ("ADMIN".equals(memberDto.getRole())) {
            memberDto.setRole(Role.ADMIN.toString());
        } else {
            memberDto.setRole(Role.MEMBER.toString());
        }
        Member member = Member.toEntity(memberDto);

        return memberRepository.save(member).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) {
        Optional<Member> memberWrapper = memberRepository.findByMemberId(memberId);
        try {
            Member member = memberWrapper.get();
            List<GrantedAuthority> authorities = new ArrayList<>();

            if (("ADMIN").equals(member.getRole()))
                authorities.add(new SimpleGrantedAuthority(Role.ADMIN.toString()));
            else
                authorities.add(new SimpleGrantedAuthority(Role.MEMBER.toString()));

            return new User(member.getLoginId(), member.getPassword(), authorities);
        } catch (InternalAuthenticationServiceException e) {
            throw new InternalAuthenticationServiceException(e.getMessage());
        }
    }
}
