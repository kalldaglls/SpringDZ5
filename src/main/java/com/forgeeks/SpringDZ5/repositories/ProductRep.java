package com.forgeeks.SpringDZ5.repositories;

import com.forgeeks.SpringDZ5.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRep extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
//    private List<Product> products = new ArrayList<>();
//
//    public List<Product> showAllProducts(){
//        if (products.isEmpty()){
//            Product newProd = new Product();
//            newProd.setId(0);
//            newProd.setTitle(null);
//            newProd.setPrice(0);
//            products.add(newProd);
//        }
//        return products;
//    }
//
//    public Product showProdById(long id){
//        return products.get((int) id);
//    }
//
//
//
//    public void addProduct(Product product){
//        products.add(product);
//    }
//
//    @Override
//    public String toString() {
//        return "ProductRep{" +
//                "products=" + products +
//                '}';
//    }
//
//    public Product findOneById(long id) {
//        Product product = null;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id){
//                product = products.get(i);
//            }
//        }
//        if(product == null){
//            return null;
//        }
//        return product;
//    }
}
