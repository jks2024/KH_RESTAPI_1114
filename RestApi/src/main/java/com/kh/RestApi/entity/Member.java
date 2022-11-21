package com.kh.RestApi.entity;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String userId;
    private String pwd;
    private String name;
    @Column(unique = true)
    private String eMail;
    private LocalDateTime regData;
}
