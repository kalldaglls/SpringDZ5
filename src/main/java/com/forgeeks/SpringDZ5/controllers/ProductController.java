package com.forgeeks.SpringDZ5.controllers;

import com.forgeeks.SpringDZ5.converters.ProductConverter;
import com.forgeeks.SpringDZ5.dto.ProductDto;
import com.forgeeks.SpringDZ5.entities.Product;
import com.forgeeks.SpringDZ5.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.service.ProductService;
import com.forgeeks.SpringDZ5.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    private final ProductValidator productValidator;

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
    @RequestParam(name = "title_part", required = false) String titlePart,
    @RequestParam(name = "secret_key_part", required = false) String secretKeyPart
){
        if(page < 1){
            page = 1;
        }

    return productService.find(minPrice, maxPrice, titlePart, secretKeyPart, page).map(
            p -> productConverter.entityToDto(p)
//            p -> new ProductDto(p.getId(), p.getTitle(), p.getPrice(), p.getSecretKey())
    );
}
//    @GetMapping("/products")
//    public List<Product> getAllProducts() {
//        return productService.findAll();
//    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return productConverter.entityToDto(product);
    }

    @GetMapping("/cart/{id}")
    public List<Optional<Product>> putProductInCart(@PathVariable Long id) {
        List<Optional<Product>> productList = productService.putToCartById(id);
        System.out.println(productList);
       return productList;
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
//        Product product = new Product();
//        product.setId(0);
//        product.setTitle(productDto.getTitle());
//        product.setPrice(productDto.getPrice());
//        productService.save(product);
//        return productDto;
        System.out.println(productDto);
        productValidator.validate(productDto);
        Product product = new Product();
        productConverter.dtoToEntity(productDto);
        product = productService.save(product);
        return productConverter.entityToDto(product);
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
//        Optional<Product> product = productService.findById(productDto.getId());
//        product.get().setTitle(productDto.getTitle());
//        product.get().setPrice(productDto.getPrice());
//        productService.save(product.get());
//        return productDto;
        productValidator.validate(productDto);
        Product product = productService.update(productDto);
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
