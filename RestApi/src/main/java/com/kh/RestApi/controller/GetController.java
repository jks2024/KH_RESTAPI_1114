package com.kh.RestApi.controller;

import com.kh.RestApi.vo.MemberVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// 별다른 설정 없이 선언하면 HTTP의 모든 요청을 받습니다.
@RequestMapping("api/v1/get-api")
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello Spring boot";
    }
    @GetMapping( "/name")
    public String getName() {
        return "Name : 천지훈";
    }
    // 매개변수를 받는 GET 메서드 구현 : 실무 환경에서는 거의 대부분 매개변수가 존재
    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String var) {
        return "당신의 이름은 " + var;
    }
    // 키와 값으로 구성된 형태로 전달하는 방법
    // GET 요청을 구현할 때 URL 경로에 쿼리 형식으로 값을 전달 하는 방식 입니다.
    // URI에서 "?"를 기준으로 우측에 '{키}={값}'
    @GetMapping("/request1")
    public String getRequestParam(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String company) {
        return "이름 : " + name + "이메일 : " + email + "회사 " + company;
    }

    @GetMapping("/member")
    public List<Map<String, Object>> getMembers() {
        List<Map<String, Object>> members = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            Map<String, Object> member = new HashMap<>();
            member.put("id", i);
            member.put("name", i + "번 개발자");
            member.put("age", 10 + i);
            members.add(member);
        }
        return members;
    }
    @GetMapping("/memberVO")
    public List<MemberVO> getMemberVO() {
        List<MemberVO> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            MemberVO vo = new MemberVO();
            vo.setId("jks2024");
            vo.setPwd("sphb8250");
            vo.setName("곰돌이사육사");
            vo.setEmail("jks2024@gmail.com");
            list.add(vo);
        }
        return list;
    }
    // @ResponseEntry : 예외 상황에 대해 좀 더 세밀한 제어가 필요한 경우 사용
    @GetMapping("/memberList")
    public ResponseEntity<List<MemberVO>> listMember() {
        List<MemberVO> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            MemberVO vo = new MemberVO();
            vo.setId("jks2024");
            vo.setPwd("sphb8250");
            vo.setName("곰돌이사육사");
            vo.setEmail("jks2024@gmail.com");
            list.add(vo);
        }
        return new ResponseEntity(list, HttpStatus.OK);
        //return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }




}
