package com.deepexi.com.deepexi.service;

import com.deepexi.com.deepexi.domain.eo.Delivery;

public interface ProductDeliveryService {

    Integer createDelivery(Delivery delivery);

    void checkParams(Delivery delivery);
}
