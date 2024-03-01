package com.phl.business.domain.main.service;

import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.client.repository.ClientRepository;
import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.helper.RestHelper;
import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.product.mapper.ProductMapper;
import com.phl.business.domain.product.model.Product;
import com.phl.business.domain.product.repository.ProductRepository;
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
public class ProductServiceImpl extends RestHelper implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    StoreMapper storeMapper;

    @Override
    public ResponseEntity<RestResponse> updateProduct(String storeId, String productId, ProductRequestDto productRequestDto) {
        Client client = getLoggedClient();
        Store store =getStoreFromClient(client,storeId);
        Product product = getProductFromStore(store,productId);
        product.updateFrom(productRequestDto);
        productRepository.save(product);
        return buildSuccess(productMapper.productToProductResponseDto(product));
    }

    // product ent is not deleting. obj/uuid
    @Override
    public ResponseEntity<RestResponse> deleteProduct(String storeId, String productId) {
        Client client = getLoggedClient();
        Store store =getStoreFromClient(client,storeId);
        Product product = getProductFromStore(store,productId);
        productRepository.delete(product);
        return buildSuccess(true);
    }

    @Override
    public ResponseEntity<RestResponse> addProducts(String storeId, List<ProductRequestDto> productRequestDtos) {
        log.info("[addProducts] Start");
        Client client = getLoggedClient();
        Store store = getStoreFromClient(client,storeId);
        log.info("[addProducts] Mapping List of ProductRequestDto to List of Product Model");
        List<Product> products = productRequestDtos.stream().map(productRequestDto -> productMapper.productDtoToProduct(productRequestDto)).toList();
        log.info("[addProducts] Adding Product to Store");
        products.forEach(store::addProduct);
        log.info("[addProducts] Saving Store with new Product/s");
        storeRepository.save(store);
        log.info("[addProducts] Done");
        return buildSuccess(products.stream().map(product -> productMapper.productToProductResponseDto(product)));
    }

    @Override
    public ResponseEntity<RestResponse> getProducts(String storeId) {
        log.info("[getStoreProducts] Start");
        Client client = getLoggedClient();
        Store store = getStoreFromClient(client,storeId);
        log.info("[getStoreProducts] Get all products and assign to a variable");
        List<Product> products = store.getProducts();
        log.info("[getStoreProducts] Done");
        return buildSuccess(products.stream().map(product -> productMapper.productToProductResponseDto(product)));
    }
}
