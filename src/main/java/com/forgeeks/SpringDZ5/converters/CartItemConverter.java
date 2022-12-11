package com.forgeeks.SpringDZ5.converters;

import com.forgeeks.SpringDZ5.dto.CartItem;
import com.forgeeks.SpringDZ5.dto.CartItemDto;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {
    public CartItemDto entityToDto(CartItem c) {
        return new CartItemDto(c.getProductId(), c.getProductTitle(), c.getQuantity(), c.getPricePerProduct(), c.getPrice());
    }
}
