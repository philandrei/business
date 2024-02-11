package com.phl.business.domain.client;

import com.phl.business.domain.client.dto.ClientRequestDto;
import com.phl.business.domain.client.dto.ClientResponseDto;
import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.client.service.ClientCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientCrudRestController {

    @Autowired
    ClientCrudService clientCrudService;

    @PostMapping
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDto) {
        return clientCrudService.createClient(clientRequestDto);
    }

    @PutMapping("/{uuid}")
    public ClientResponseDto updateClient(@PathVariable String uuid, @RequestBody ClientRequestDto clientRequestDto){
        return clientCrudService.updateClient(uuid, clientRequestDto);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientCrudService.getAllClients();
    }

    @GetMapping("/{uuid}")
    public Client getOneClient(@PathVariable String uuid) {
        return clientCrudService.getOneClient(uuid);
    }

    @DeleteMapping("/{uuid}")
    public String deleteClient(@PathVariable String uuid){ return clientCrudService.deleteClient(uuid);}




}
