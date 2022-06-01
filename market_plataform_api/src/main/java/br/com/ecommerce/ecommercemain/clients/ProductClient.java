package br.com.ecommerce.ecommercemain.clients;

import br.com.ecommerce.ecommercemain.dtos.products.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "products")
//@LoadBalancerClient(name = "products")
public interface ProductClient {
    @GetMapping(path="products")
    @CircuitBreaker(name = "servico")
    List<ProductDTO> getAllProducts();
}
