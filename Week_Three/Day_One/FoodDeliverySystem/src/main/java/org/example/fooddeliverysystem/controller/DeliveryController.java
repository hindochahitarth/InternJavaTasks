package org.example.fooddeliverysystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.fooddeliverysystem.dto.DeliveryPartnerRequest;
import org.example.fooddeliverysystem.entity.DeliveryPartner;
import org.example.fooddeliverysystem.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/partners/register")
    public ResponseEntity<DeliveryPartner> registerDeliveryPartner(@RequestBody DeliveryPartnerRequest request) {
        DeliveryPartner savedDeliveryPartner = deliveryService.registerDeliveryPartner(request);
        log.info("From controller " + savedDeliveryPartner.toString());
        return new ResponseEntity<>(savedDeliveryPartner, HttpStatus.CREATED);

    }
}
