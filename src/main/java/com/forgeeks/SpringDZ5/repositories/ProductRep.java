package com.forgeeks.SpringDZ5.repositories;

import com.forgeeks.SpringDZ5.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRep extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

}
