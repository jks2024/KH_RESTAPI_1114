package com.kh.RestApi.controller;
import com.kh.RestApi.service.MemberService;
import com.kh.RestApi.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class MemberController {
    // Service 로직 연결
    private MemberService memberService;
    public  MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 개별 회원 조회
    @GetMapping("/GetMember")
    public ResponseEntity <List<MemberVO>> memberList(@RequestParam String userId) {
        List<MemberVO> list = memberService.getMemberList(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 로그인 체크
    @PostMapping("/Login")
    public ResponseEntity<Boolean> memberLogin(@RequestBody Map<String, String> loginData) {
        String getUser = loginData.get("user");
        String getPwd = loginData.get("pwd");
        boolean result = memberService.getLoginCheck(getUser, getPwd);
        if(result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(true, HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("MemberCheck")
//    public ResponseEntity<Map<String, String>> memberCheck(@RequestBody Map<String, String> chkData) {
//    }

    // 회원 가입
    @PostMapping("/RegMember")
    public ResponseEntity<Map<String, String>> memberRegister(@RequestBody Map<String, String> regData) {
        String getUserId = regData.get("user");
        String getPwd = regData.get("pwd");
        String getName = regData.get("name");
        String getMail = regData.get("mail");
        boolean result = memberService.regMember(getUserId, getPwd, getName, getMail);
        if(result) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

}
