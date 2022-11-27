package com.forgeeks.SpringDZ5.converters;

import com.forgeeks.SpringDZ5.dto.ProductDto;
import com.forgeeks.SpringDZ5.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
//        System.out.println("DTO id: " + productDto.getId());
//        System.out.println("ProductDto: " + productDto);
//        Product product = new Product();
//        System.out.println("PROD id: " + product.getId());
//        product.setTitle(productDto.getTitle());
//        product.setPrice(productDto.getPrice());
//        product.setSecretKey(productDto.getSecretKey());
//        System.out.println(product);
        return new Product(productDto.getId(), productDto.getPrice(), productDto.getTitle(), productDto.getSecretKey());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.getSecretKey());
    }
}
