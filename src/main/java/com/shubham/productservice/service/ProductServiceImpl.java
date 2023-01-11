package com.shubham.productservice.service;

import com.shubham.productservice.Errors.ProductAlreadyExsistsException;
import com.shubham.productservice.Exception.ProductServiceCustomException;
import com.shubham.productservice.entity.Product;
import com.shubham.productservice.model.ProductRequest;
import com.shubham.productservice.model.ProductResponse;
import com.shubham.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Long addProduct(ProductRequest productRequest) {
       // Product product=new Product();

        //BeanUtils.copyProperties(productRequest,product);
       // Optional<Product> theproduct= productRepository.findById(product.getProductId());

       /* if (theproduct.isPresent())
            throw new ProductAlreadyExsistsException("This product with id:"+product.getProductId()+"Already exists in DB");
        log.info("Checking if product already exists in DB ");*/



        //log.info("Adding "+productRequest +"in DB");

        log.info("Inside ProductServiceImpl in addProduct");
        Product product=Product.builder().productId(productRequest.getId()).productName(productRequest.getName())
                .price(productRequest.getPrice()).quantity(productRequest.getQuantity()).build();
        productRepository.save(product);


   log.info("Product entity is created with id"+product.getProductId());
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
   log.info("in the product service impl");
   log.info("calling db to fetch product by id");
       Product product=productRepository.findById(productId)
               .orElseThrow(()->new ProductServiceCustomException("Product with id :"+productId+"not found", "PRODUCT_NOT_FOUND"));

       ProductResponse productResponse= new ProductResponse();
       BeanUtils.copyProperties(product,productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce quantity with ID{} by quantity{}"+productId+""+quantity);
        Product product=productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceCustomException("ProductID: "+productId+"Not found","PRODUCT_NOT_FOUND"));

        if(product.getQuantity()<quantity){
            throw new ProductServiceCustomException("ProductQuantity is less to be reduced","LESS_PRODUCT_QUANTITY");
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
    }
}
