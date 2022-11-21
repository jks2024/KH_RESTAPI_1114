package com.kh.RestApi.dao;

import com.kh.RestApi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUserIdAndPwd(String user, String pwd);
    List<Member> findByUserId(String user);
}
