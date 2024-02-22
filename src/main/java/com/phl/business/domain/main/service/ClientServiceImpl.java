package com.phl.business.domain.main.service;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phl.business.domain.authentication.AuthUserDetails;
import com.phl.business.domain.client.dto.ClientRequestDto;
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
import com.phl.business.domain.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class ClientServiceImpl extends RestHelper implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    ProductMapper productMapper;


    @Override
    public ResponseEntity<RestResponse> getAllStores() {
        Client client = getLoggedClient();
        List<Store> stores = client.getStores();
        return buildSuccess(stores.stream().map(store -> storeMapper.storeToStoreResponseDto(store)));
    }

    @Override
    public ResponseEntity<RestResponse> updateClient(ClientRequestDto clientRequestDto) {
        Client client = getLoggedClient();
        client.updateFrom(clientRequestDto);
        clientRepository.save(client);
        return buildSuccess(client);
    }

    @Override
    public ResponseEntity<RestResponse> findOneClient() {
        return buildSuccess(getLoggedClient());
    }
}
