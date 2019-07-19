package com.deepexi.com.deepexi.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.com.deepexi.domain.eo.Delivery;
import com.deepexi.com.deepexi.enums.ResultEnum;
import com.deepexi.com.deepexi.extension.AppRuntimeEnv;
import com.deepexi.com.deepexi.mapper.ProductDeliveryMapper;
import com.deepexi.com.deepexi.service.ProductDeliveryService;
import com.deepexi.util.IdGenerator;
import com.deepexi.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.deepexi.util.extension.ApplicationException;
import javax.annotation.Resource;

@Component
@Service(version = "${demo.service.version}")
public class ProductDeliveryServiceImpl implements ProductDeliveryService {

    @Resource
    public ProductDeliveryMapper productDeliveryMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public Integer createDelivery(Delivery delivery) {
        delivery.setId(IdGenerator.getUuId());
        delivery.setDr(0);
        return productDeliveryMapper.createDelivery(delivery);

    }

    @Override
    public void checkParams(Delivery delivery) {
        if(StringUtil.isBlank(delivery.getCustomerId())){
            throw new ApplicationException(ResultEnum.USER_NOT_NULL);
        }
        else if(StringUtil.isBlank(delivery.getAddress())){
            throw new ApplicationException(ResultEnum.ADDRESS_NOT_NULL);
        }
         else if(StringUtil.isBlank(delivery.getTelephone())){
             throw new ApplicationException((ResultEnum.TELEPHONE_NOT_NULL));
        }

    }
}
