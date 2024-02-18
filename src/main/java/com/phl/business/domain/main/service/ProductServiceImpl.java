package com.phl.business.domain.main.service;

import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.client.repository.ClientRepository;
import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.helper.RestHelper;
import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.product.model.Product;
import com.phl.business.domain.product.repository.ProductRepository;
import com.phl.business.domain.store.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl extends RestHelper implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<RestResponse> updateProduct(String storeId, String productId, ProductRequestDto productRequestDto) {
        Client client = getLoggedClient();
        Store store =getStoreFromClient(client,storeId);
        Product product = getProductFromStore(store,productId);
        product.updateFrom(productRequestDto);
        productRepository.save(product);
        return buildSuccess(product);
    }

    @Override
    public ResponseEntity<RestResponse> deleteProduct(String storeId, String productId) {
        Client client = getLoggedClient();
        Store store =getStoreFromClient(client,storeId);
        Product product = getProductFromStore(store,productId);
        productRepository.delete(product);
        return buildSuccess(true);
    }
}
