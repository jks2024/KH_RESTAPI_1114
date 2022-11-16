package com.kh.RestApi.entity;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="new_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String pwd;
    private String name;
    private String email;
    private LocalDateTime join;
}
