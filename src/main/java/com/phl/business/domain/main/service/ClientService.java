package com.phl.business.domain.main.service;

import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.store.dto.StoreRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {

    ResponseEntity<RestResponse> addStore(String clientId, StoreRequestDto storeRequestDto);
    ResponseEntity<RestResponse> addProducts(String clientId, String storeId, List<ProductRequestDto> productRequestDtos);
}
