package br.com.xfrontier.housekeeper.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xfrontier.housekeeper.api.dtos.requests.PaymentRequest;
import br.com.xfrontier.housekeeper.api.dtos.responses.MessageResponse;
import br.com.xfrontier.housekeeper.api.services.ApiDailyPaymentService;
import br.com.xfrontier.housekeeper.core.permissions.EHousekeeperPermissions;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/daily/{id}")
public class DailyPaymentRestController {

    @Autowired
    private ApiDailyPaymentService service;

    @EHousekeeperPermissions.isHousekeeperOrCustomer
    @PostMapping("/pay")
    public MessageResponse pay(@RequestBody @Valid PaymentRequest request, @PathVariable Long id) {
        return service.pay(request, id);
    }

}
