package com.kh.RestApi.dao;

import com.kh.RestApi.entity.MemberInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional
class CartRepositoryTest {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    MemberRepository memberRepository;

    public MemberInfo createMemberInfo() {
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setUserId("JKS2024");
        memberInfo.setPwd("SPHB8250");
        memberInfo.setName("곰돌이사육사");
        memberInfo.setEmail("jks2024@gmail.com");
        memberInfo.setJoin(LocalDateTime.now());
        return memberInfo;
    }

    @Test
    @DisplayName("장바구니 회원 매핑 조회 테스트")
    public void findCartAndMemberTest() {

    }


}