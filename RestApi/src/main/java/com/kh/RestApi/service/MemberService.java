package com.kh.RestApi.service;

import com.kh.RestApi.dao.MemberRepository;
import com.kh.RestApi.entity.MemberInfo;
import com.kh.RestApi.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public List<MemberVO> getMemberList(String userId) {
        List<MemberInfo> memberInfoList = memberRepository.findByUserId(userId);
        for(MemberInfo info : memberInfoList) {
            MemberVO memberVO = new MemberVO();
            memberVO.setUser(info.getUserId());
            memberVO.setPwd(info.getPwd());
            memberVO.setName(info.getName());

        }
        return null;
    }
}
