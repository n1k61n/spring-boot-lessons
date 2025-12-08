package com.example.shaverma.data.repoImpls.collectionFrw;

import com.example.shaverma.domain.model.Delivery;
import com.example.shaverma.domain.repo.DeliveryRepo;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRepoImpl implements DeliveryRepo {

    private final List<Delivery> deliveries = new ArrayList<>();

    @Override
    public Delivery saveDelivery(Delivery delivery) {
        deliveries.add(delivery);
        return delivery;
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        int index = deliveries.indexOf(delivery);
        if (index != -1) {
            deliveries.set(index, delivery);
        }
        return delivery;
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveries.stream()
                .filter(delivery -> delivery.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
