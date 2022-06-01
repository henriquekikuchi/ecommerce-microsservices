package com.github.willyoliv.sales.mapper;

import com.github.willyoliv.sales.dto.SaleRequestDTO;
import com.github.willyoliv.sales.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale saleRequestDTOToSale(SaleRequestDTO saleRequestDTO);
}
