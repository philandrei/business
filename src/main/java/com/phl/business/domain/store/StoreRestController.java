package com.phl.business.domain.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreRestController {

    @Autowired
    StoreService storeService;

    @PostMapping
    public StoreResponseDto createStore(@RequestBody StoreRequestDto storeRequestDto) {
        return storeService.saveStore(storeRequestDto);
    }

    @PutMapping("/{uuid}")
    public StoreResponseDto updateStore(@PathVariable String uuid,@RequestBody StoreRequestDto storeRequestDto){
        return storeService.updateStore(uuid,storeRequestDto);
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{uuid}")
    public Store getStore(@PathVariable String uuid) {
        return storeService.getOneStore(uuid);
    }

   @DeleteMapping("/{uuid}")
    public String deleteStore(@PathVariable String uuid){return storeService.deleteStore(uuid);}
}
