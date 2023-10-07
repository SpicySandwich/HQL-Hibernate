package com.hibernate.service.impl;

import com.hibernate.model.Product;
import com.hibernate.repository.ProductRepo;
import com.hibernate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProduct() {
        return productRepo.listProduct();
    }

    @Override
    public void addProduct(Product product) {
        productRepo.saveProduct(product);

    }

    @Override
    public Product findProduct(Integer id) {
        return productRepo.findProduct(id);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.deleteProduct(id);

    }

    @Override
    public void updateProduct(Product product) {
        productRepo.saveProduct(product);
    }
}
