package com.kh.RestApi.dao;
import com.kh.RestApi.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberInfo, Long> {
    List<MemberInfo> findByUserId(String userId);
}
