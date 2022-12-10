package com.forgeeks.SpringDZ5.controllers;

import com.forgeeks.SpringDZ5.converters.CartConverter;
import com.forgeeks.SpringDZ5.dto.Cart;
import com.forgeeks.SpringDZ5.dto.CartDto;
import com.forgeeks.SpringDZ5.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
        System.out.println(cartService.getCurrentCart());
    }

    @GetMapping
    public CartDto getCurrentCart() {
        return cartConverter.entityToDto(cartService.getCurrentCart());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFromCart(@PathVariable Long id) {
        cartService.delete(id);
    }
}
