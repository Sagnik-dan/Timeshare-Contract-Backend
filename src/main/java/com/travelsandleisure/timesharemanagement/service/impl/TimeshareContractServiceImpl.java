package com.travelsandleisure.timesharemanagement.service.impl;

import com.travelsandleisure.timesharemanagement.dto.TimeshareContractRequest;
import com.travelsandleisure.timesharemanagement.dto.TimeshareContractResponse;
import com.travelsandleisure.timesharemanagement.entity.Client;
import com.travelsandleisure.timesharemanagement.entity.Hotel;
import com.travelsandleisure.timesharemanagement.entity.TimeshareContract;
import com.travelsandleisure.timesharemanagement.exception.ClientNotFoundException;
import com.travelsandleisure.timesharemanagement.exception.HotelNotFoundException;
import com.travelsandleisure.timesharemanagement.exception.TimeshareContractNotFoundException;
import com.travelsandleisure.timesharemanagement.repository.ClientRepository;
import com.travelsandleisure.timesharemanagement.repository.HotelRepository;
import com.travelsandleisure.timesharemanagement.repository.TimeshareContractRepository;
import com.travelsandleisure.timesharemanagement.service.TimeshareContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeshareContractServiceImpl implements TimeshareContractService {

    private final TimeshareContractRepository contractRepository;
    private final ClientRepository clientRepository;
    private final HotelRepository hotelRepository;

    @Override
    public TimeshareContractResponse createContract(
            TimeshareContractRequest request) {

        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() ->
                        new ClientNotFoundException(
                                "Client not found with id "
                                        + request.getClientId()));

        Hotel hotel = hotelRepository.findById(request.getHotelId())
                .orElseThrow(() ->
                        new HotelNotFoundException(
                                "Hotel not found with id "
                                        + request.getHotelId()));

        TimeshareContract contract = new TimeshareContract();

        contract.setContractNumber(request.getContractNumber());
        contract.setPurchaseDate(request.getPurchaseDate());
        contract.setStartDate(request.getStartDate());
        contract.setEndDate(request.getEndDate());
        contract.setContractValue(request.getContractValue());
        contract.setStatus(request.getStatus());

        contract.setClient(client);
        contract.setHotel(hotel);

        TimeshareContract savedContract =
                contractRepository.save(contract);

        return mapToResponse(savedContract);
    }

    @Override
    public List<TimeshareContractResponse> getAllContracts() {

        return contractRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TimeshareContractResponse getContractById(Long id) {

        TimeshareContract contract =
                contractRepository.findById(id)
                        .orElseThrow(() ->
                                new TimeshareContractNotFoundException(
                                        "Contract not found with id "
                                                + id));

        return mapToResponse(contract);
    }

    private TimeshareContractResponse mapToResponse(
            TimeshareContract contract) {

        return TimeshareContractResponse.builder()
                .contractId(contract.getContractId())
                .contractNumber(contract.getContractNumber())
                .contractValue(contract.getContractValue())
                .purchaseDate(contract.getPurchaseDate())
                .startDate(contract.getStartDate())
                .endDate(contract.getEndDate())
                .status(contract.getStatus())
                .clientName(
                        contract.getClient().getFirstName()
                                + " "
                                + contract.getClient().getLastName())
                .hotelName(
                        contract.getHotel().getHotelName())
                .build();
    }
}