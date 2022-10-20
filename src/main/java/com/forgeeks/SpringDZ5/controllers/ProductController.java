package com.forgeeks.SpringDZ5.controllers;

import com.forgeeks.SpringDZ5.entities.Product;
import com.forgeeks.SpringDZ5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/products")
    public List<Product> getAllStudents() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public Product saveNewProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
