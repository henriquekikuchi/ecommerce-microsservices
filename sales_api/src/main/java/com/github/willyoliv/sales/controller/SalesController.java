package com.github.willyoliv.sales.controller;

import com.github.willyoliv.sales.dto.SaleRequestDTO;
import com.github.willyoliv.sales.entity.Sale;
import com.github.willyoliv.sales.mapper.SaleMapper;
import com.github.willyoliv.sales.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("sales")
public class SalesController {
    private final SaleService saleService;

    private final SaleMapper saleMapper;

    @PostMapping
    private ResponseEntity<Sale> saveSale(@Valid @RequestBody SaleRequestDTO saleRequestDTO) {
        Sale sale = saleMapper.saleRequestDTOToSale(saleRequestDTO);
        return new ResponseEntity(saleService.saveSale(sale), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping(path = "/{saleId}")
    private ResponseEntity<Sale> getSaleById(@PathVariable("saleId") Long saleId) {
        return ResponseEntity.ok(saleService.getSaleById(saleId));
    }

    @GetMapping(path = "/find-by-user-code/{userCode}")
    private ResponseEntity<List<Sale>> getAllSalesByUserCode(@PathVariable("userCode") UUID userCode) {
        return ResponseEntity.ok(saleService.getAllSalesByUserCode(userCode));
    }
}
