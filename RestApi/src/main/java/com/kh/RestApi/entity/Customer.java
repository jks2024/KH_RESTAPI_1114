package com.kh.RestApi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {
    @Id
    // 키 값을 생성하는 전략 : 기본키 생성을 JPA기준
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String firstPhone;
}
