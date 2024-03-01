package com.phl.business.domain.store.service;

import com.phl.business.domain.store.dto.StoreRequestDto;
import com.phl.business.domain.store.dto.StoreResponseDto;
import com.phl.business.domain.store.mapper.StoreMapper;
import com.phl.business.domain.store.model.Store;
import com.phl.business.domain.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StoreCrudServiceImpl implements StoreCrudService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private StoreMapper storeMapper;
    @Override
    public StoreResponseDto saveStore(StoreRequestDto storeRequestDto) {
        Store store = storeMapper.storeDtoToStore(storeRequestDto);
        storeRepository.save(store);
        return storeMapper.storeToStoreResponseDto(store);
    }

    @Override
    public StoreResponseDto updateStore(String uuid,StoreRequestDto storeRequestDto) {
        Store existingStore = storeRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
        existingStore.updateFrom(storeRequestDto);
        storeRepository.save(existingStore);
        return storeMapper.storeToStoreResponseDto(existingStore);
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


}
