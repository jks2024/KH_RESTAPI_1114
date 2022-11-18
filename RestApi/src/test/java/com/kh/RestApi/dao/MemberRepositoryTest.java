package com.kh.RestApi.dao;
import com.kh.RestApi.entity.MemberInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Test
    @DisplayName("회원 가입 테스트")
    public void regMemberTest() {
        for(int i = 1; i <= 10; i++) {
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setUserId("JKS2024" + i);
            memberInfo.setPwd("SPHB8250");
            memberInfo.setName("곰돌이사육사" + i);
            memberInfo.setEmail("jks2024@gmail.com");
            memberInfo.setJoin(LocalDateTime.now());
            memberRepository.save(memberInfo);
        }
    }
}