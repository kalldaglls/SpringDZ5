package com.forgeeks.SpringDZ5.service;

import com.forgeeks.SpringDZ5.dto.ProductDto;
import com.forgeeks.SpringDZ5.entities.Product;
import com.forgeeks.SpringDZ5.repositories.ProductRep;
import com.forgeeks.SpringDZ5.repositories.specifications.ProductsSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRep productRep;
    private final List<Optional<Product>> productList = new ArrayList<>();

    public Page<Product> find(Integer minPrice, Integer maxPrice, String titlePart, String secretKeyPart, Integer page){
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null){
            spec = spec.and(ProductsSpecifications.priceGreaterOrEqualsThan(minPrice));
        }

        if (maxPrice != null){
            spec = spec.and(ProductsSpecifications.priceLessThanOrEqualsThan(maxPrice));
        }

        if (titlePart != null){
            spec = spec.and(ProductsSpecifications.titleLike(titlePart));
        }

        if (secretKeyPart != null){
            spec = spec.and(ProductsSpecifications.secretKeyLike(secretKeyPart));
        }
        return productRep.findAll(spec, PageRequest.of(page - 1, 10));
    }

    public List<Product> findAll() {
        return productRep.findAll();
    }

    public void deleteById(Long id) {
        productRep.deleteById(id);
    }

    public Product save(Product product) {
        return productRep.save(product);
    }

    //    @Autowired
//    public void setProductRep(ProductRep productRep) {
//        this.productRep = productRep;
//    }
//
//    public Product getProductById(int id) {
//        return productRep.findOneById(id);
//    }
//
//    public ProductRep getProductRep() {
//        return productRep;
//    }
//


    public Optional<Product> findById(Long id) {
        return productRep.findById(id);
    }

    @Transactional
    public Product update(ProductDto productDto) {
        Product product = productRep.findById(productDto.getId()).orElseThrow(() -> new RuntimeException("Невозможно обновить продукта, не надйен в базе, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        product.setSecretKey(productDto.getSecretKey());
        return product;
    }

    public  List<Optional<Product>> putToCartById(Long id) {
        productList.add(productRep.findById(id));
        System.out.println(productList);
        return productList;
    }
}
