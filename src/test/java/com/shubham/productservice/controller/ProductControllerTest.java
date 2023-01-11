package com.shubham.productservice.controller;

import com.shubham.productservice.model.ProductResponse;
import com.shubham.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testgetProductById(){
        ProductResponse productResponse=new ProductResponse();
        when(productService.getProductById(anyLong())).thenReturn(productResponse);
        ResponseEntity<ProductResponse> response = productController.getProductById(456);
        Assert.notNull(response);
    }


}