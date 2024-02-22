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

    @PutMapping("/{storeId}")
    public ResponseEntity<RestResponse> updateStore(@PathVariable String storeId,
                                                    @RequestBody StoreRequestDto storeRequestDto) {
        return storeService.updateStore(storeId, storeRequestDto);
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<RestResponse> deleteStore(@PathVariable String storeId) {
        return storeService.deleteStore(storeId);
    }

    @GetMapping("/{storeId}")
    public  ResponseEntity<RestResponse> getOneStore(@PathVariable String storeId){
        return storeService.findOneStore(storeId);
    }

    //Store - Products


}
