package com.phl.business.domain.main.service;

import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.store.dto.StoreRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StoreService {

    ResponseEntity<RestResponse> addStore(StoreRequestDto storeRequestDto);
    ResponseEntity<RestResponse> addStoreProducts(String storeId, List<ProductRequestDto> productRequestDtos);
    ResponseEntity<RestResponse> getStoreProducts(String storeId);
}
