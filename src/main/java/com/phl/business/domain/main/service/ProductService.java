package com.phl.business.domain.main.service;

import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.product.dto.ProductRequestDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<RestResponse> updateProduct(String storeId, String productId, ProductRequestDto productRequestDto);
    ResponseEntity<RestResponse> deleteProduct(String storeId, String productId);
}
