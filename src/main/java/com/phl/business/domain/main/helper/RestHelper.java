package com.phl.business.domain.main.helper;

import com.phl.business.domain.authentication.AuthUserDetails;
import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.client.repository.ClientRepository;
import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.product.model.Product;
import com.phl.business.domain.store.model.Store;
import com.phl.business.domain.user.model.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.NoSuchElementException;

@Slf4j
public class RestHelper {
    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    protected ClientRepository clientRepository;

    protected User getUser() {
        AuthUserDetails authUserDetails = (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authUserDetails.getUser();

    }
    protected Client getLoggedClient(){
        return clientRepository.findById(getClientId()).orElseThrow(() -> new NoSuchElementException("Invalid clientId"));
    }

    protected Store getStoreFromClient(Client client, String storeId){
        return client.getStores()
                       .stream()
                       .filter(store -> store.getUuid().equals(storeId))
                       .findFirst()
                       .orElseThrow(() -> new NoSuchElementException("Invalid storeId"));;
    }

    protected Product getProductFromStore(Store store, String productId){
        return store.getProducts()
                       .stream()
                       .filter(product -> product.getUuid().equals(productId))
                       .findFirst()
                       .orElseThrow(() ->  new NoSuchElementException("Invalid productId"));
    }

    protected String getClientId() {
        User user = getUser();
        return user.getClient().getUuid();
    }

    public ResponseEntity<RestResponse> buildSuccess(Object obj){
        log.info("[buildSuccess] Building success response");
        return ResponseEntity.ok(RestResponse.builder()
                                         .path(httpServletRequest.getRequestURI())
                                         .timestamp(new Date())
                                         .status(200)
                                         .message("Success")
                                         .data(obj)
                                         .build());
    }
}
