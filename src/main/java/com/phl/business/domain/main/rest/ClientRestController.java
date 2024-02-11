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

    @PostMapping("/store/{clientId}")
    public ResponseEntity<RestResponse> addStore(@PathVariable String clientId, @RequestBody StoreRequestDto storeRequestDto) {
        return clientService.addStore(clientId, storeRequestDto);
    }

    @PostMapping("/products/{clientId}/{storeId}")
    public ResponseEntity<RestResponse> addProducts(@PathVariable String clientId,
                                                    @PathVariable String storeId,
                                                    @RequestBody List<ProductRequestDto> productRequestDtoList){
        return clientService.addProducts(clientId,storeId,productRequestDtoList);
    }
}
