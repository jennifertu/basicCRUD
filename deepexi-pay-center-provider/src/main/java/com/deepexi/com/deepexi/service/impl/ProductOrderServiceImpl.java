package com.deepexi.com.deepexi.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.com.deepexi.domain.eo.Product;
import com.deepexi.com.deepexi.extension.AppRuntimeEnv;
import com.deepexi.com.deepexi.mapper.ProductOrderMapper;
import com.deepexi.com.deepexi.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(version = "${demo.service.version}")
public class ProductOrderServiceImpl implements ProductOrderService {


//    @Autowired
//    private ProductOrderMapper productOrderMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public int createProductOrder(Product product) {


        return 0;
    }

    @Override
    public int createOrder(Product product) {
        return 0;
    }
}
