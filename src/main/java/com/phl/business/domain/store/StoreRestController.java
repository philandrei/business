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
    public Store createStore(@RequestBody Store store) {
        return storeService.saveStore(store);
    }

    @PutMapping("/{uuid}")
    public Store updateStore(@PathVariable String uuid,@RequestBody Store store){
        return storeService.updateStore(uuid,store);
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
