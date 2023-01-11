package com.shubham.productservice.model;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductRequest {

 private long id;
 @NotNull
 @NotEmpty
 private String name;
 @NotNull
 @NotEmpty
 private long price;
 @NotNull
 private long quantity;
}
