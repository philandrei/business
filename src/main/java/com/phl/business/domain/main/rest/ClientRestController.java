package com.phl.business.domain.main.rest;


import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.service.ClientService;
import com.phl.business.domain.store.dto.StoreRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @PostMapping("/store/{customerId}")
    public ResponseEntity<RestResponse> addStore(@PathVariable String customerId, @RequestBody StoreRequestDto storeRequestDto) {
        return clientService.createStore(customerId, storeRequestDto);
    }
}
