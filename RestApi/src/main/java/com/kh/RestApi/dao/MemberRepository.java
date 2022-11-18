package com.kh.RestApi.dao;

import com.kh.RestApi.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<MemberInfo, String> {
    List<MemberInfo> findByUserIdAndPwd(String user, String pwd);
    List<MemberInfo> findByUserId(String user);
}
