package com.example.shaverma.domain.repo;

import com.example.shaverma.domain.model.Delivery;

public interface DeliveryRepo{
    Delivery saveDelivery(Delivery delivery);
    Delivery updateDelivery(Delivery delivery);
    Delivery getDeliveryById(Long id);

}
