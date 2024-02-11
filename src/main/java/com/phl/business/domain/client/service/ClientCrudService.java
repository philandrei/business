package com.phl.business.domain.client.service;


import com.phl.business.domain.client.dto.ClientRequestDto;
import com.phl.business.domain.client.dto.ClientResponseDto;
import com.phl.business.domain.client.model.Client;

import java.util.List;

public interface ClientCrudService {

    ClientResponseDto createClient(ClientRequestDto customer);
    ClientResponseDto updateClient(String uuid, ClientRequestDto clientRequestDto);

    List<Client> getAllClients();

    Client getOneClient(String uuid);

    String deleteClient(String uuid);


}
