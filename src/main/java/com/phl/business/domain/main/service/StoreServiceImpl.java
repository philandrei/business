package com.phl.business.domain.main.service;

import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.client.repository.ClientRepository;
import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.helper.RestHelper;
import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.product.mapper.ProductMapper;
import com.phl.business.domain.product.model.Product;
import com.phl.business.domain.store.dto.StoreRequestDto;
import com.phl.business.domain.store.mapper.StoreMapper;
import com.phl.business.domain.store.model.Store;
import com.phl.business.domain.store.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class StoreServiceImpl extends RestHelper implements StoreService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseEntity<RestResponse> addStore(StoreRequestDto storeRequestDto) {
        log.info("[addStore] Start");
        String clientId = getClientId();
        Client client = getLoggedClient();
        log.info("[addStore] Mapping StoreRequestDto to Store Model");
        Store store = storeMapper.storeDtoToStore(storeRequestDto);
        log.info("[addStore] Adding Store to client");
        client.addStore(store);
        log.info("[addStore] Saving client with new Store");
        clientRepository.save(client);
        log.info("[addStore] Done");
        return buildSuccess(client);
    }

    @Override
    public ResponseEntity<RestResponse> updateStore(String storeId, StoreRequestDto storeRequestDto) {
        Client client = getLoggedClient();
        Store store = getStoreFromClient(client,storeId);
        store.updateFrom(storeRequestDto);
        storeRepository.save(store);
        return buildSuccess(store);
    }

    //Need to check why ent is not getting deleted obj/uuid
    @Override
    public ResponseEntity<RestResponse> deleteStore(String storeId) {
        Client client = getLoggedClient();
        Store store = getStoreFromClient(client,storeId);
        storeRepository.delete(store);
        return buildSuccess(true);
    }
}
