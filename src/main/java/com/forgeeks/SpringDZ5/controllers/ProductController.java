package com.forgeeks.SpringDZ5.controllers;

import com.forgeeks.SpringDZ5.converters.ProductConverter;
import com.forgeeks.SpringDZ5.dto.ProductDto;
import com.forgeeks.SpringDZ5.entities.Product;
import com.forgeeks.SpringDZ5.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.service.ProductService;
import com.forgeeks.SpringDZ5.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;
//    private final ProductValidator productValidator;
//@GetMapping("/pages")
//public Page<ProductDto> getAllProducts(
//    @RequestParam(name = "p", defaultValue = "1") Integer page,
//    @RequestParam(name = "min_price", required = false) Integer minPrice,
//    @RequestParam(name = "max_price", required = false) Integer maxPrice,
//    @RequestParam(name = "title_part", required = false) String titlePart
//){
//        if(page < 1){
//            page = 1;
//        }
//
//    return productService.find(minPrice, maxPrice, titlePart, page).map(
//            productConverter::entityToDto
//    );
//}
    @GetMapping
    public List<ProductDto> getAllProducts() {
        List<Product> products = productService.findAll();
//        System.out.println(products);
//        System.out.println(products);
//        return (List<ProductDto>) productConverter.entityToDto((Product) products);
        return productConverter.entityListToDtoList(products);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return productConverter.entityToDto(product);
    }

//    @PostMapping
//    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
//        System.out.println(productDto);
//        productValidator.validate(productDto);
//        Product product = productConverter.dtoToEntity(productDto);
//        product = productService.save(product);
//        return productConverter.entityToDto(product);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewProduct(@RequestBody ProductDto productDto) {
        productService.createNewProduct(productDto);
    }

//    @PutMapping
//    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
//        productValidator.validate(productDto);
//        Product product = productService.update(productDto);
//        return productConverter.entityToDto(product);
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
