package com.phl.business.domain.main.service;

import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.store.dto.StoreRequestDto;
import org.springframework.http.ResponseEntity;

public interface ClientService {

    ResponseEntity<RestResponse> createStore(String customerId, StoreRequestDto storeRequestDto);
}
