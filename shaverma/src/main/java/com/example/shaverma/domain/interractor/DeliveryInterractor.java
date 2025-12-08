package com.example.shaverma.domain.interractor;


import com.example.shaverma.domain.model.Delivery;
import com.example.shaverma.domain.repo.DeliveryRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeliveryInterractor{
    
    private final DeliveryRepo deliveryRepo;

    public Delivery createDelivery(Delivery delivery){
        return deliveryRepo.saveDelivery(delivery);
    }

    public Delivery changeDelivery(Delivery delivery){
        return deliveryRepo.updateDelivery(delivery);
    }

    public Delivery getDeliveryById(Long id){
        return deliveryRepo.getDeliveryById(id);
    }

}


