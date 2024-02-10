package com.phl.business.domain.store;

import java.util.List;

public interface StoreService {

    Store saveStore(Store Store);

    List<Store> getAllStores();

    Store getOneStore(String uuid);

    String deleteStore(String uuid);

    Store updateStore(String uuid,Store Store);
}
