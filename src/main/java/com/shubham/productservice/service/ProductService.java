package com.shubham.productservice.service;

import com.shubham.productservice.model.ProductRequest;
import com.shubham.productservice.model.ProductResponse;

public interface ProductService {
    Long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
