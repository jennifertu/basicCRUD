package com.deepexi.com.deepexi.service;

import com.deepexi.com.deepexi.domain.eo.Product;

public interface ProductOrderService {

    public int createProductOrder(Product product);

    int createOrder(Product product);
}
