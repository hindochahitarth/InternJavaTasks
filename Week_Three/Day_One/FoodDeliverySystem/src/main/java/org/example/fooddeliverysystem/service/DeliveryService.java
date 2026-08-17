package org.example.fooddeliverysystem.service;

import lombok.extern.slf4j.Slf4j;
import org.example.fooddeliverysystem.dto.DeliveryPartnerRequest;
import org.example.fooddeliverysystem.entity.DeliveryPartner;
import org.example.fooddeliverysystem.entity.DeliveryPartnerStatus;
import org.example.fooddeliverysystem.entity.Role;
import org.example.fooddeliverysystem.entity.User;
import org.example.fooddeliverysystem.repository.DeliveryPartnerRepository;
import org.example.fooddeliverysystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeliveryService {
    private final DeliveryPartnerRepository deliveryPartnerRepository;
    private final UserRepository userRepository;

    public DeliveryService(DeliveryPartnerRepository deliveryPartnerRepository,UserRepository userRepository){
        this.deliveryPartnerRepository=deliveryPartnerRepository;
        this.userRepository=userRepository;
    }
    public DeliveryPartner registerDeliveryPartner(DeliveryPartnerRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        log.info("user id "+user.getRole()+"request "+request.getUserId());
        if(user.getRole()!= Role.DELIVERY_PARTNER){
            throw new RuntimeException("User is not a delivery partner");
        }
        DeliveryPartner deliveryPartner=new DeliveryPartner();
        log.info(String.valueOf(deliveryPartner));
        deliveryPartner.setUser(user);
        deliveryPartner.setVehicleNumber(request.getVehicleNumber());
        deliveryPartner.setLicenseNumber(request.getLicenseNumber());
        deliveryPartner.setVehicleType(request.getVehicleType());
        deliveryPartner.setStatus(DeliveryPartnerStatus.AVAILABLE);
        deliveryPartner.setRating(0.0);
        deliveryPartner.setTotalDeliveris(0);
        log.info("From service "+deliveryPartner);


        DeliveryPartner savedDeliveryPartner=deliveryPartnerRepository.save(deliveryPartner);
        return  savedDeliveryPartner;
    }

    }
