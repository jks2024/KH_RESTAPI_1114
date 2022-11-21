package com.kh.RestApi.service;
import com.kh.RestApi.dao.MemberRepository;
import com.kh.RestApi.entity.Member;
import com.kh.RestApi.vo.MemberDTO;
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
    public List<MemberDTO> getMemberList() {
        List<MemberDTO> memberDTOS = new ArrayList<>();
        List<Member> memberList = memberRepository.findAll();
        for(Member e : memberList) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setUser(e.getUserId());
            memberDTO.setPwd(e.getPwd());
            memberDTO.setName(e.getName());
            memberDTO.setEmail(e.getEMail());
            memberDTO.setGrade("VIP");
            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }
    public List<MemberDTO> getMemberList(String user) {
        List<MemberDTO> memberDTOS = new ArrayList<>();
        List<Member> memberList = memberRepository.findByUserId(user);
        for(Member e : memberList) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setUser(e.getUserId());
            memberDTO.setPwd(e.getPwd());
            memberDTO.setName(e.getName());
            memberDTO.setEmail(e.getEMail());
            memberDTO.setGrade("VIP");
            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }
    // 로그인 체크
    public boolean loginCheck(String userId, String pwd) {
        List<Member> memberList = memberRepository.findByUserIdAndPwd(userId, pwd);
        for(Member info : memberList) {
            return true;
        }
        return false;
    }

    // 회원 가입
    public boolean regMember(String userId, String pwd, String name, String mail) {
        Member member = new Member();
        member.setUserId(userId);
        member.setPwd(pwd);
        member.setName(name);
        member.setEMail(mail);
        member.setRegData(LocalDateTime.now());
        Member rst = memberRepository.save(member);
        log.warn(rst.toString());
        return true;
    }
}
