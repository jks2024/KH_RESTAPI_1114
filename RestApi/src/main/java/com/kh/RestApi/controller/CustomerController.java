package com.kh.RestApi.controller;
import com.kh.RestApi.dao.CustomerRepository;
import com.kh.RestApi.entity.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/customer") // 회원 데이터 생성
    public Customer putCustomer(Customer customer) {
        return repository.save(customer);
    }
    @PostMapping("/customer") // 회원 정보 수정
    public Customer postCustomer(Customer customer) {
        return repository.save(customer);
    }
    @DeleteMapping("/customer")
    public void deleteCustomer(int id) {
        repository.deleteById(id);
    }
    @GetMapping("/customer")
    public Customer getCustomer(int id) {
        return repository.findById(id).orElse(null); // 찾는 값이 없으면 null 반환
    }
    @GetMapping("/customer/list")
    public List<Customer> getCustomer() {
        return repository.findAll();
    }
    @GetMapping("/customer/name")
    public List<Customer> getCustomer(String name) {
        return repository.findByName(name);
    }
    @GetMapping("/customer/address")
    public List<Customer> getCustomerAddr(String address) {
        return repository.findByAddressLike("%" + address + "%");
    }
    // Like 검색 해보기
    @GetMapping("customer/search")
    public List<Customer> searchCustomer(String name) {
        //return repository.findByNameLike("%" + name + "%");
        return repository.findByNameLikeOrderByAddressDesc("%" + name + "%");
    }
    // 이름 또는 주소에 맞는 항목 검색 하기
    @GetMapping("customer/name-addr")
    public List<Customer> getCustomerNameOrAddr(String name, String address) {
        return repository.findByNameOrAddress(name, address);
    }
    // Native 쿼리 호출
    @GetMapping("customer/name-addr-cust")
    public List<Customer> getNativeNameAndAddr(String name, String address) {
        return repository.findVipList1(name, address);
    }

}
