package com.kh.RestApi.controller;
import com.kh.RestApi.service.MemberService;
import com.kh.RestApi.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MemberController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());
    // Service 로직 연결
    private MemberService memberService;
    public  MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/GetMember")
    public ResponseEntity <List<MemberVO>> memberList(@RequestParam String userId) {
        LOGGER.info("회원 조회 아이디 : " + userId);
        List<MemberVO> list = memberService.getMemberList(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/Login")
    public Map<String, String> memberLogin(@RequestBody Map<String, String> loginData) {
        String getId = loginData.get("id");
        String getPwd = loginData.get("pwd");
        LOGGER.info("Login Controller Call !!!!");
        Map<String, String> map = new HashMap<>();

        return map;
    }
    @PostMapping("MemberCheck")
    public ResponseEntity<Map<String, String>> memberCheck(@RequestBody Map<String, String> chkData) {
        String getId = chkData.get("id");
        Map<String, String> map = new HashMap<>();
        map.put("result", "OK");
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @PostMapping("/RegMember")
    public ResponseEntity<Map<String, String>> memberRegister(@RequestBody Map<String, String> regData) {
        String getId = regData.get("id");
        String getPwd = regData.get("pwd");
        String getName = regData.get("name");
        String getMail = regData.get("mail");

        Map<String, String> map = new HashMap<>();
        map.put("result", "OK");
        return new ResponseEntity(map, HttpStatus.OK);
    }

}
