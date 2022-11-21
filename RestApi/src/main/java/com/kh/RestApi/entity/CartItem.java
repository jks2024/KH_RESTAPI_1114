package com.kh.RestApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

//    @ManyToOne  // 하나의 장바구니에는 여러 개의 상품을 담을 수 있으므로 다대일 관계로 매핑
//    @JoinColumn(name = "cart_id")


}
