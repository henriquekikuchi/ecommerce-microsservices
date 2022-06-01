package com.github.willyoliv.sales.client;

import com.github.willyoliv.sales.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "products")
public interface ProductClient {

    @PutMapping(path = "/products/update-stock")
    String updateStock(List<Product> products);
}
