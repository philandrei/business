package com.phl.business.domain.store;

import com.phl.business.domain.store.dto.StoreRequestDto;
import com.phl.business.domain.store.dto.StoreResponseDto;
import com.phl.business.domain.store.model.Store;
import com.phl.business.domain.store.service.StoreCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores/crud")
public class StoreCrudRestController {

    @Autowired
    StoreCrudService storeCrudService;

    @PostMapping
    public StoreResponseDto createStore(@RequestBody StoreRequestDto storeRequestDto) {
        return storeCrudService.saveStore(storeRequestDto);
    }

    @PutMapping("/{uuid}")
    public StoreResponseDto updateStore(@PathVariable String uuid,@RequestBody StoreRequestDto storeRequestDto){
        return storeCrudService.updateStore(uuid,storeRequestDto);
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeCrudService.getAllStores();
    }

    @GetMapping("/{uuid}")
    public Store getStore(@PathVariable String uuid) {
        return storeCrudService.getOneStore(uuid);
    }

   @DeleteMapping("/{uuid}")
    public String deleteStore(@PathVariable String uuid){return storeCrudService.deleteStore(uuid);}
}
