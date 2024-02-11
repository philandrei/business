package com.phl.business.domain.client.service;

import com.phl.business.domain.client.dto.ClientRequestDto;
import com.phl.business.domain.client.dto.ClientResponseDto;
import com.phl.business.domain.client.mapper.ClientMapper;
import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientCrudServiceImpl implements ClientCrudService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientResponseDto createClient(ClientRequestDto clientRequestDto) {
        Client client = clientMapper.customerDtoToClient(clientRequestDto);
        clientRepository.save(client);
        return clientMapper.customerToClientResponseDto(client);
    }

    @Override
    public ClientResponseDto updateClient(String uuid, ClientRequestDto clientRequestDto) {
        Client existingClient = clientRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
        existingClient.updateFrom(clientRequestDto);
        clientRepository.save(existingClient);
        return clientMapper.customerToClientResponseDto(existingClient);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getOneClient(String uuid) {
        return clientRepository.findById(uuid).orElse(null);
    }

    @Override
    public String deleteClient(String uuid) {
        clientRepository.deleteById(uuid);
        return uuid;
    }


}
