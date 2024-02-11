package com.phl.business.domain.main.rest;


import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.service.ClientService;
import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.store.dto.StoreRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @PostMapping("/store")
    public ResponseEntity<RestResponse> addStore(@RequestBody StoreRequestDto storeRequestDto) {
        return clientService.addStore(storeRequestDto);
    }

    @PostMapping("/products/{storeId}")
    public ResponseEntity<RestResponse> addProducts(@PathVariable String storeId,
                                                    @RequestBody List<ProductRequestDto> productRequestDtoList){
        return clientService.addProducts(storeId,productRequestDtoList);
    }
}
