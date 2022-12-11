package com.forgeeks.SpringDZ5.controllers;

import com.forgeeks.SpringDZ5.converters.ProductConverter;
import com.forgeeks.SpringDZ5.entities.Product;
import com.forgeeks.SpringDZ5.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.service.MyCart;
import com.forgeeks.SpringDZ5.service.ProductService;
import com.forgeeks.SpringDZ5.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carts/new")
@RequiredArgsConstructor
public class MyCartController {
//    private final ProductService productService;
//    private final MyCart cart;
//    private final ProductConverter productConverter;
//    private final ProductValidator productValidator;
//
//    @GetMapping
//    public MyCart getAllProductsFromCart() {
//        return cart.findAll();
//    }
//
//    @GetMapping("/add/{id}")
//    public void addProductToCartById(@PathVariable Long id) {
//        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
//        cart.addProduct(product);
//    }
//
//
//    @GetMapping("/remove/{id}")
//    public void deleteProductFromCartById(@PathVariable Long id) {
//        cart.deleteById(id);
//    }
}
