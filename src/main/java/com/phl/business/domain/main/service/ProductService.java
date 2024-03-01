package com.phl.business.domain.main.service;

import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.product.dto.ProductRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<RestResponse> updateProduct(String storeId, String productId, ProductRequestDto productRequestDto);
    ResponseEntity<RestResponse> deleteProduct(String storeId, String productId);
    ResponseEntity<RestResponse> addProducts(String storeId, List<ProductRequestDto> productRequestDtos);
    ResponseEntity<RestResponse> getProducts(String storeId);
}
