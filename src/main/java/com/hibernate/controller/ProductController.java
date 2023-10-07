package com.hibernate.controller;

import com.hibernate.model.Product;
import com.hibernate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sync")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product-list")
    public ResponseEntity<List<Product>> productList(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/find-product")
    public ResponseEntity<Product> findProduct(@RequestParam Integer id){
        return  new ResponseEntity<>(productService.findProduct(id),HttpStatus.OK);
    }
    @PostMapping("/store-product")
    public ResponseEntity<Void> storeProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/remove-product")
    public ResponseEntity<Void> deleteProduct(@RequestParam Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update-product")
    public ResponseEntity<Void> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
