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
public class StoreServiceImpl extends RestHelper implements StoreService{

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
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new NoSuchElementException("Invalid clientId"));
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
    public ResponseEntity<RestResponse> addStoreProducts(String storeId, List<ProductRequestDto> productRequestDtos) {
        log.info("[addProducts] Start");
        String clientId = getClientId();
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new NoSuchElementException("Invalid clientId"));
        Store store = client.getStore().stream().filter(store1 -> store1.getUuid().equals(storeId)).findFirst().orElseThrow(() -> new NoSuchElementException("Invalid storeId"));
        log.info("[addProducts] Mapping List of ProductRequestDto to List of Product Model");
        List<Product> products = productRequestDtos.stream().map(productRequestDto -> productMapper.productDtoToProduct(productRequestDto)).toList();
        log.info("[addProducts] Adding Product to Store");
        products.forEach(store::addProduct);
        log.info("[addProducts] Saving Store with new Product/s");
        storeRepository.save(store);
        log.info("[addProducts] Done");
        return buildSuccess(store);
    }

    @Override
    public ResponseEntity<RestResponse> getStoreProducts(String storeId) {
        log.info("[getStoreProducts] Start");
        String clientId = getClientId();
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new NoSuchElementException("Invalid clientId"));
        Store store = client.getStore().stream().filter(store1 -> store1.getUuid().equals(storeId)).findFirst().orElseThrow(() -> new NoSuchElementException("Invalid Store ID"));
        log.info("[getStoreProducts] Get all products and assign to a variable");
        List<Product> products = store.getProducts();
        log.info("[getStoreProducts] Done");
        return buildSuccess(products);
    }
}
