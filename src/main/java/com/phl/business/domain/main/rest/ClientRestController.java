package com.phl.business.domain.main.rest;


import com.phl.business.domain.client.dto.ClientRequestDto;
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

    @GetMapping("/stores")
    public ResponseEntity<RestResponse> getAllStores() {
        return clientService.getAllStores();
    }

    @PutMapping
    public ResponseEntity<RestResponse> updateClient(@RequestBody ClientRequestDto clientRequestDto) {
        return clientService.updateClient(clientRequestDto);
    }

    @GetMapping
    public ResponseEntity<RestResponse> findOneClient() {
        return clientService.findOneClient();
    }
}
