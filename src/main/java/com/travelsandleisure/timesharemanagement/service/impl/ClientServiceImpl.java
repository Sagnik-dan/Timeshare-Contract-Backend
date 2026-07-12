package com.travelsandleisure.timesharemanagement.service.impl;

import com.travelsandleisure.timesharemanagement.dto.ClientRequest;
import com.travelsandleisure.timesharemanagement.dto.ClientResponse;
import com.travelsandleisure.timesharemanagement.entity.Client;
import com.travelsandleisure.timesharemanagement.exception.ClientNotFoundException;
import com.travelsandleisure.timesharemanagement.repository.ClientRepository;
import com.travelsandleisure.timesharemanagement.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    @Override
    public ClientResponse createClient(ClientRequest request) {

        Client client = new Client();

        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setAddress(request.getAddress());
        client.setDateOfBirth(request.getDateOfBirth());

        Client saved = clientRepository.save(client);

        return mapToResponse(saved);
    }

    @Override
    public ClientResponse getClientById(Long id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ClientNotFoundException(
                                "Client not found with id " + id));

        return mapToResponse(client);
    }

    @Override
    public List<ClientResponse> getAllClients() {

        return clientRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteClient(Long id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ClientNotFoundException(
                                "Client not found with id " + id));

        clientRepository.delete(client);
    }

    private ClientResponse mapToResponse(Client client) {

        return ClientResponse.builder()
                .clientId(client.getClientId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .address(client.getAddress())
                .dateOfBirth(client.getDateOfBirth())
                .build();
    }

}