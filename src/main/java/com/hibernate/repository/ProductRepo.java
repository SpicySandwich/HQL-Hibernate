package com.hibernate.repository;

import com.hibernate.model.Product;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ProductRepo {


    List<Product> listProduct();
    void saveProduct(Product product);
    Product findProduct(Integer id);
    void deleteProduct(Integer id);
}
