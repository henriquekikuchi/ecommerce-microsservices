package com.api.products.service;

import com.api.products.entity.Product;
import com.api.products.exception.ProductInvalidAmountException;
import com.api.products.exception.ProductNotFoundException;
import com.api.products.exception.ProductInsufficientStockException;
import com.api.products.repository.ProductRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        product.setProductCode(UUID.randomUUID());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void updateStockProducts(List<Product> products) {
        List<Product> listProductsToUpdate = products.stream().map(produto -> {
            Product prodFound = findByUUID(produto.getProductCode());
            if (produto.getQuantity() <= 0) {
                throw new ProductInvalidAmountException("Invalid amount of products!");
            }
            if (prodFound.getQuantity() < produto.getQuantity()) {
                throw new ProductInsufficientStockException("Insufficient product stock");
            }
            prodFound.setQuantity(prodFound.getQuantity() - produto.getQuantity());
            return prodFound;
        }).collect(Collectors.toList());
        productRepository.saveAll(listProductsToUpdate);
    }

    private Product findByUUID(UUID productCode) {
        return productRepository.findByProductCode(productCode)
                .orElseThrow(()->new ProductNotFoundException("Product productCode " + productCode + " not found!"));
    }

}
