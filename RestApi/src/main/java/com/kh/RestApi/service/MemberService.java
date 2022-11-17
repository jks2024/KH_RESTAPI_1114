package com.kh.RestApi.service;

import com.kh.RestApi.dao.MemberRepository;
import com.kh.RestApi.entity.MemberInfo;
import com.kh.RestApi.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 아이디로 회원 조회
    public List<MemberVO> getMemberList(String userId) {
        List<MemberVO> memberVOList = new ArrayList<>();
        List<MemberInfo> memberInfoList = memberRepository.findByUserId(userId);
        for(MemberInfo info : memberInfoList) {
            MemberVO memberVO = new MemberVO();
            memberVO.setUser(info.getUserId());
            memberVO.setPwd(info.getPwd());
            memberVO.setName(info.getName());
            memberVO.setEmail(info.getEmail());
            memberVO.setGrade("VIP");
            memberVOList.add(memberVO);
        }
        return memberVOList;
    }
    // 로그인 체크
    public boolean getLoginCheck(String userId, String pwd) {
        List<MemberInfo> memberInfoList = memberRepository.findByUserIdAndPwd(userId, pwd);
        for(MemberInfo info : memberInfoList) {
            return true;
        }
        return false;
    }

    // 회원 가입
    public boolean regMember(String userId, String pwd, String name, String mail) {
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setUserId(userId);
        memberInfo.setPwd(pwd);
        memberInfo.setName(name);
        memberInfo.setEmail(mail);
        memberInfo.setJoin(LocalDateTime.now());
        MemberInfo rst = memberRepository.save(memberInfo);
        log.warn(rst.toString());
        return true;
    }
    // 가입 여부 체크
    public boolean checkMember(String userId) {
        List<MemberInfo> memberInfoList = memberRepository.findByUserId(userId);
        for(MemberInfo info : memberInfoList) {
            return false; // 가입된 회원이므로 false;
        }
        return true;
    }
}
