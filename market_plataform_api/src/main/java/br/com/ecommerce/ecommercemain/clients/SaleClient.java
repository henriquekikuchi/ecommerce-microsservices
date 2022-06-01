package br.com.ecommerce.ecommercemain.clients;

import br.com.ecommerce.ecommercemain.dtos.sales.SalesRequestDTO;
import br.com.ecommerce.ecommercemain.dtos.sales.SalesResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "sales")
//@LoadBalancerClient(name = "sales")
public interface SaleClient {

    @PostMapping(path = "sales")
    @CircuitBreaker(name = "servico")
    SalesResponseDTO save(@RequestBody SalesRequestDTO salesRequestDTO);

    @GetMapping(path = "sales/find-by-user-code/{userCode}")
    @CircuitBreaker(name = "servico")
    List<SalesResponseDTO> findByUserCode(@PathVariable("userCode") UUID userCode);

}
