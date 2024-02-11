package com.phl.business.domain.client.mapper;

import com.phl.business.domain.client.dto.ClientRequestDto;
import com.phl.business.domain.client.dto.ClientResponseDto;
import com.phl.business.domain.client.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client customerDtoToClient(ClientRequestDto clientRequestDto) {
        Client client = Client.builder()
                                    .email(clientRequestDto.getEmail())
                                    .mobileNumber(clientRequestDto.getMobileNumber())
                                    .firstName(clientRequestDto.getFirstName())
                                    .lastName(clientRequestDto.getLastName())
                                    .build();
        return client;
    }

    public ClientRequestDto customerToClientDto(Client client) {
        ClientRequestDto clientRequestDto = ClientRequestDto.builder()
                                                        .email(client.getEmail())
                                                        .firstName(client.getFirstName())
                                                        .lastName(client.getLastName())
                                                        .mobileNumber(client.getMobileNumber())
                                                        .build();
        return clientRequestDto;
    }

    public ClientResponseDto customerToClientResponseDto(Client client) {
        ClientResponseDto clientResponseDto = ClientResponseDto.builder()
                                                          .uuid(client.getUuid())
                                                          .email(client.getEmail())
                                                          .firstName(client.getFirstName())
                                                          .lastName(client.getLastName())
                                                          .mobileNumber(client.getMobileNumber())
                                                          .uuid(client.getUuid())
                                                          .build();
        return clientResponseDto;
    }
}
