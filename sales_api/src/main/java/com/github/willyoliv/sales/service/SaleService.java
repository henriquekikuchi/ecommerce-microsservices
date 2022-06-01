package com.github.willyoliv.sales.service;

import com.github.willyoliv.sales.entity.Sale;

import java.util.List;
import java.util.UUID;

public interface SaleService {
    public Sale saveSale(Sale sale);

    public List<Sale> getAllSales();

    public Sale getSaleById(Long saleId);

    public List<Sale> getAllSalesByUserCode(UUID userCode);
}
