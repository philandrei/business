package com.phl.business.domain.store;

import java.util.List;

public interface StoreService {

    StoreResponseDto saveStore(StoreRequestDto Store);
    StoreResponseDto updateStore(String uuid,StoreRequestDto Store);
    List<Store> getAllStores();
    Store getOneStore(String uuid);
    String deleteStore(String uuid);

}
