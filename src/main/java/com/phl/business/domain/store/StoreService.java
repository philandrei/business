package com.phl.business.domain.store;

import java.util.List;

public interface StoreService {

    Store saveStore(Store Store);

    List<Store> getAllStores();

    Store getStoreByUuid(String uuid);

    String deleteStoreByUuid(String uuid);

    Store updateStore(String uuid,Store Store);
}
