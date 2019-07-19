package com.deepexi.com.deepexi.service;

import com.deepexi.com.deepexi.domain.eo.Order;
import com.deepexi.com.deepexi.domain.eo.Product;
import org.springframework.stereotype.Component;

import java.util.List;


@Component

public interface ProductOrderService {

    int createProductOrder(Product product);

    int createOrder(Order order);

    void checkParams(Order order);

    List<Order> selectOrderBy(String user);
}
