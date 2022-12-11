package com.forgeeks.SpringDZ5.converters;

import com.forgeeks.SpringDZ5.dto.Cart;
import com.forgeeks.SpringDZ5.dto.CartDto;

import org.springframework.stereotype.Component;


import java.util.stream.Collectors;

@Component
public class CartConverter {
    private final CartItemConverter cartItemConverter;

    public CartDto entityToDto(Cart c) {
        return new CartDto(c.getItems().stream().map(cartItemConverter::entityToDto).collect(Collectors.toList()), c.getTotalPrice());
    }
}
