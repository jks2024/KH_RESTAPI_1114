package com.kh.RestApi.dao;
import com.kh.RestApi.entity.MemberInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;

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
            memberInfo.setId(1l + i);
            memberInfo.setUserId("JKS2024" + i);
            memberInfo.setPwd("SPHB8250");
            memberInfo.setName("곰돌이사육사" + i);
            memberInfo.setEmail("jks2024@gmail.com");
            memberInfo.setJoin(LocalDateTime.now());
            memberRepository.save(memberInfo);
        }
    }
    @Test
    @DisplayName("개별 회원 조회 테스트")
    public void findByUserIdTest() {
        this.regMemberTest();
        List<MemberInfo> memberInfoList = memberRepository.findByUserId("JKS20241");
        for(MemberInfo info : memberInfoList) {
            log.warn(info.toString());
        }
    }
    @Test
    @DisplayName("전체 회원 조회 테스트")
    public void findAllTest() {
        this.regMemberTest();
        List<MemberInfo> memberInfoList = memberRepository.findAll();
        for(MemberInfo info : memberInfoList) {
            log.warn(info.toString());
        }
    }

}