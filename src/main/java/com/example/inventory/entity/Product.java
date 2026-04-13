package com.example.inventory.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;
    private int price;
    private String purchase;

    // 기본 생성자
    public Product() {}

    // getter / setter
    public Long getId() {
        return id;
    }

    //상품명
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //수량
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //가격
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //구매날짜
    public String getPurchase() {
        return purchase;
    }
    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }


}