package com.kh.RestApi.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
    private String user;
    private String pwd;
    private String name;
    private String email;
    private String grade;
}