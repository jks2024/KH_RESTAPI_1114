package com.kh.RestApi.entity;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="member_info")
public class MemberInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String pwd;
    private String name;
    private String email;
    private LocalDateTime join;
}
