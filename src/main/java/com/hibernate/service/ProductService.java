package com.hibernate.service;

import com.hibernate.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void addProduct(Product product);
    Product findProduct(Integer id);
    void deleteProduct(Integer id);
    void updateProduct(Product product);

}
