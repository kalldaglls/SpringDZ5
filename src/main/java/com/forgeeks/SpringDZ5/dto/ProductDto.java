package com.forgeeks.SpringDZ5.dto;


import com.forgeeks.SpringDZ5.entities.Product;

public class ProductDto {
    private Long id;
    private String title;
    private Integer price;

//    private String secretKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

//    public String getSecretKey() {
//        return secretKey;
//    }

//    public void setSecretKey(String secretKey) {
//        this.secretKey = secretKey;
//    }

    public ProductDto(Product product) {
        this.title = product.getTitle();
        this.id = product.getId();
        this.price = product.getPrice();
//        this.secretKey = product.getSecretKey();
    }

    public ProductDto() {
    }
}
