package com.travelsandleisure.timesharemanagement.service;

import com.travelsandleisure.timesharemanagement.dto.ClientRequest;
import com.travelsandleisure.timesharemanagement.dto.ClientResponse;

import java.util.List;

public interface ClientService {

    ClientResponse createClient(ClientRequest request);

    ClientResponse getClientById(Long id);

    List<ClientResponse> getAllClients();

    void deleteClient(Long id);
}