package com.phl.business.domain.product.service;

import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.product.dto.ProductResponseDto;
import com.phl.business.domain.product.model.Product;

import java.util.List;

public interface ProductCrudService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto updateProduct(String uuid, ProductRequestDto productRequestDto);
    List<Product> getAllProducts();
    Product getOneProduct(String uuid);
    String deleteProduct(String uuid);

}
