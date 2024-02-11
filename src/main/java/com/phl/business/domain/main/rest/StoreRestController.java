package com.phl.business.domain.main.rest;

import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.service.ClientService;
import com.phl.business.domain.main.service.StoreService;
import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.store.dto.StoreRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreRestController {

    @Autowired
    StoreService storeService;

    @PostMapping
    public ResponseEntity<RestResponse> addStore(@RequestBody StoreRequestDto storeRequestDto) {
        return storeService.addStore(storeRequestDto);
    }

    @PostMapping("/{storeId}/products")
    public ResponseEntity<RestResponse> addStoreProducts(@PathVariable String storeId,
                                                    @RequestBody List<ProductRequestDto> productRequestDtoList) {
        return storeService.addStoreProducts(storeId, productRequestDtoList);
    }

    @GetMapping("/{storeId}/products")
    public ResponseEntity<RestResponse> getAllStoreProducts(@PathVariable String storeId) {
        return storeService.getStoreProducts(storeId);
    }

}
