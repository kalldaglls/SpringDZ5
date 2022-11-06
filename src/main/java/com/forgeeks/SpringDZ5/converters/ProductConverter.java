package com.forgeeks.SpringDZ5.converters;

import com.forgeeks.SpringDZ5.dto.ProductDto;
import com.forgeeks.SpringDZ5.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getPrice(), productDto.getTitle(), productDto.getSecretKey());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.getSecretKey());
    }
}
