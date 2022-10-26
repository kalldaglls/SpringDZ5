package com.forgeeks.SpringDZ5.controllers;

import com.forgeeks.SpringDZ5.dto.ProductDto;
import com.forgeeks.SpringDZ5.entities.Product;
import com.forgeeks.SpringDZ5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping
//    public ResponseEntity getUsers(){
//        try {
//            return ResponseEntity.ok("Сервер работает");
//        } catch (Exception e){
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }

//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @RequestMapping("/showProduct")
//    public String hello(Model uiModel) {
//        List<Product> list = productService.getProductRep().showAllProducts();
//        System.out.println(list);
//        uiModel.addAttribute("product", list);
//        return "product";
//    }
//
//    @RequestMapping("/showForm")
//    public String showSimpleForm(Model uiModel) {
//        Product product = new Product();
//        uiModel.addAttribute("product", product);
//        return "product-form";
//    }
//
//
//    @RequestMapping("/processForm")
//    public String processForm(@ModelAttribute("product") Product product) {
//        productService.getProductRep().addProduct(product);
//        System.out.println(productService.getProductRep().showAllProducts());
//        return "product-form-result";
//    }
//
//    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
//    @ResponseBody
//    public Product showStudentById(Model uiModel, @RequestParam long id) {
//        Product product = productService.getProductById((int) id);
//        return product;
//    }
@GetMapping
public Page<ProductDto> getAllProducts(
    @RequestParam(name = "p", defaultValue = "1") Integer page,
    @RequestParam(name = "min_price", required = false) Integer minPrice,
    @RequestParam(name = "max_price", required = false) Integer maxPrice,
    @RequestParam(name = "title_part", required = false) String titlePart
//    @RequestParam(name = "secret_key_part", required = false) String secretKeyPart
){
        if(page < 1){
            page = 1;
        }

    return productService.find(minPrice, maxPrice, titlePart, page).map(
            p -> new ProductDto(p)
    );
}
//    @GetMapping("/products")
//    public List<Product> getAllProducts() {
//        return productService.findAll();
//    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow();
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setId(0);
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        productService.save(product);
        return productDto;
    }
//    @PostMapping
//    public Product saveNewProduct(@RequestBody Product product) {
//        product.setId(0);
//        return productService.save(product);
//    }

//    @GetMapping("/products/delete/{id}")
//    public void deleteById(@PathVariable Long id) {
//        productService.deleteById(id);
//    }

//    @PutMapping
//    public Product updateProduct(@RequestBody Product product) {
//        return productService.save(product);
//    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Optional<Product> product = productService.findById(productDto.getId());
        product.get().setTitle(productDto.getTitle());
        product.get().setPrice(productDto.getPrice());
        productService.save(product.get());
        return productDto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
