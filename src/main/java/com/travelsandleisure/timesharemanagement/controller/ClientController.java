package com.travelsandleisure.timesharemanagement.controller;

import com.travelsandleisure.timesharemanagement.dto.ClientRequest;
import com.travelsandleisure.timesharemanagement.dto.ClientResponse;
import com.travelsandleisure.timesharemanagement.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {


    private final ClientService clientService;

    @PostMapping
    public ClientResponse createClient(
           @Valid @RequestBody ClientRequest request) {

        return clientService.createClient(request);
    }

    @GetMapping
    public List<ClientResponse> getAllClients() {

        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientResponse getClientById(
            @PathVariable Long id) {

        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(
            @PathVariable Long id) {

        clientService.deleteClient(id);
    }
}