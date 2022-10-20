package com.forgeeks.SpringDZ5.service;

import com.forgeeks.SpringDZ5.entities.Product;
import com.forgeeks.SpringDZ5.repositories.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRep productRep;

    public ProductService(ProductRep productRep) {
        this.productRep = productRep;
    }

    public List<Product> findAll() {
        return productRep.findAll();
    }

    public void deleteById(Long id) {
        productRep.deleteById(id);
    }

    public Product save(Product product) {
        return productRep.save(product);
    }

    //    @Autowired
//    public void setProductRep(ProductRep productRep) {
//        this.productRep = productRep;
//    }
//
//    public Product getProductById(int id) {
//        return productRep.findOneById(id);
//    }
//
//    public ProductRep getProductRep() {
//        return productRep;
//    }
//
    public ProductService() {

    }
}
