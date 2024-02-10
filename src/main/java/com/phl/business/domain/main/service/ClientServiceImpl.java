package com.phl.business.domain.main.service;

import com.phl.business.domain.customer.model.Customer;
import com.phl.business.domain.customer.repository.CustomerRepository;
import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.helper.RestHelper;
import com.phl.business.domain.store.dto.StoreRequestDto;
import com.phl.business.domain.store.mapper.StoreMapper;
import com.phl.business.domain.store.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientServiceImpl extends RestHelper implements ClientService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    StoreMapper storeMapper;
    @Override
    public ResponseEntity<RestResponse> createStore(String customerId, StoreRequestDto storeRequestDto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new NoSuchElementException("Invalid customerId"));
        Store store = storeMapper.storeDtoToStore(storeRequestDto);
        customer.setStore(store);
        customerRepository.save(customer);
        return buildSuccess(customer);
    }
}
