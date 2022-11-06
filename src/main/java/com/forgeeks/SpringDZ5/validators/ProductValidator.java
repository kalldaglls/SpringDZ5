package com.forgeeks.SpringDZ5.validators;

import com.forgeeks.SpringDZ5.dto.ProductDto;
import com.forgeeks.SpringDZ5.exceptions.ValidationException;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate(ProductDto productDto){
        List<String> errors = new ArrayList<>();
        if (productDto.getPrice() < 1) {
            errors.add("Цена продукта не может быть меньше 1!");
        }
        if (productDto.getTitle().isBlank()){
            errors.add("Не может быть продукта без названия!");
        }

        if (!errors.isEmpty()){
            throw new ValidationException(errors);
        }
    }
}
