package com.shubham.productservice.controller;

import com.shubham.productservice.entity.Product;
import com.shubham.productservice.model.ProductRequest;
import com.shubham.productservice.model.ProductResponse;
import com.shubham.productservice.service.ProductService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){

        Long productId=productService.addProduct(productRequest);

        return new ResponseEntity<>(productId, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){

         log.info("In product  controller");
        ProductResponse productResponse=productService.getProductById(productId);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);

    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId,@RequestParam long quantity){

        productService.reduceQuantity(productId,quantity);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
