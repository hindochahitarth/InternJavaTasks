package org.example.fooddeliverysystem.repository;

import org.example.fooddeliverysystem.entity.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner,Long> {
    @Query("SELECT dp FROM DeliveryPartner dp WHERE dp.status = 'AVAILABLE' ORDER BY dp.rating DESC")
    List<DeliveryPartner> findAvailableDeliveryPartners();
}
