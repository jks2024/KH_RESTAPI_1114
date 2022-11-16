package com.kh.RestApi.dao;

import com.kh.RestApi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByName(String name);
    List<Customer> findByAddressLike(String address);
    List<Customer> findByNameLike(String name);
    List<Customer> findByNameLikeOrderByAddressDesc(String name);
    List<Customer> findByNameOrAddress(String name, String address);
    List<Customer> findByNameAndAddress(String name, String address);

    // Native 쿼리 방법
    @Query(value = "select * from Customer where name = ?1  and address = ?2", nativeQuery = true)
    List<Customer> findVipList2(String name, String address);
    // JPQL(Java Persistence Query Language)
    @Query("from Customer where name = ?1 and address = ?2")
    List<Customer> findVipList1(String name, String address);

}
