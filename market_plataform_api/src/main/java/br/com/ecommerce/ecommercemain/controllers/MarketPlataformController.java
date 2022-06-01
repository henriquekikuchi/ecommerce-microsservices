package br.com.ecommerce.ecommercemain.controllers;

import br.com.ecommerce.ecommercemain.clients.ProductClient;
import br.com.ecommerce.ecommercemain.clients.SaleClient;
import br.com.ecommerce.ecommercemain.clients.UserClient;
import br.com.ecommerce.ecommercemain.dtos.products.ProductDTO;
import br.com.ecommerce.ecommercemain.dtos.users.UserLoginDTO;
import br.com.ecommerce.ecommercemain.dtos.users.UserLoginResponseDTO;
import br.com.ecommerce.ecommercemain.dtos.users.UserResponseDTO;
import br.com.ecommerce.ecommercemain.dtos.users.UserSaveDTO;
import br.com.ecommerce.ecommercemain.dtos.sales.SalesRequestDTO;
import br.com.ecommerce.ecommercemain.dtos.sales.SalesResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class MarketPlataformController {

    private final UserClient userClient;

    private final ProductClient productClient;

    private final SaleClient saleClient;

    @GetMapping
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("MARKETPLATAFORM - API");
    }

    @PostMapping("/users/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
        return new ResponseEntity<>(userClient.login(userLoginDTO), HttpStatus.OK);
    }

    @PostMapping("/users/save")
    public ResponseEntity<UserLoginResponseDTO> saveUser(@RequestBody UserSaveDTO userSaveDTO) {
        return new ResponseEntity<>(userClient.save(userSaveDTO), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productClient.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/sales/save")
    public ResponseEntity<SalesResponseDTO> saveSale(@RequestBody SalesRequestDTO salesRequestDTO) {
        return new ResponseEntity<>(saleClient.save(salesRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/sales/find-by-user-code/{userCode}")
    private ResponseEntity<List<SalesResponseDTO>> getAllSalesByUserCode(@PathVariable("userCode") UUID userCode) {
        return ResponseEntity.ok(saleClient.findByUserCode(userCode));
    }

}
