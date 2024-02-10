package com.phl.business.domain.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreRepository storeRepository;
    @Override
    public Store saveStore(Store Store) {
        return storeRepository.save(Store);
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getOneStore(String uuid) {
        return storeRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public String deleteStore(String uuid) {
        storeRepository.deleteById(uuid);
        return uuid;
    }

    @Override
    public Store updateStore(String uuid,Store store) {
        Store existingStore = storeRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
        existingStore.setName(store.getName());
        storeRepository.save(existingStore);
        return existingStore;
    }
}
