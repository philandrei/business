package com.phl.business.domain.store.service;

import com.phl.business.domain.store.dto.StoreRequestDto;
import com.phl.business.domain.store.dto.StoreResponseDto;
import com.phl.business.domain.store.model.Store;

import java.util.List;

public interface StoreService {

    StoreResponseDto saveStore(StoreRequestDto Store);
    StoreResponseDto updateStore(String uuid,StoreRequestDto Store);
    List<Store> getAllStores();
    Store getOneStore(String uuid);
    String deleteStore(String uuid);

}
