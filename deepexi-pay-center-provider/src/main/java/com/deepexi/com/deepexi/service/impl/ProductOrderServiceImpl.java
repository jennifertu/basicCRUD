package com.deepexi.com.deepexi.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deepexi.com.deepexi.domain.eo.Order;
import com.deepexi.com.deepexi.domain.eo.Product;
import com.deepexi.com.deepexi.enums.ResultEnum;
import com.deepexi.com.deepexi.extension.AppRuntimeEnv;
import com.deepexi.com.deepexi.mapper.ProductOrderMapper;
import com.deepexi.com.deepexi.service.ProductOrderService;
import com.deepexi.util.IdGenerator;
import com.deepexi.util.StringUtil;
import com.deepexi.util.extension.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service(version = "${demo.service.version}")
public class ProductOrderServiceImpl implements ProductOrderService {


    @Resource
    private ProductOrderMapper productOrderMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public int createProductOrder(Product product) {


        return 0;
    }

    @Override
    public int createOrder(Order order) {
        order.setId(IdGenerator.getUuId());
        int createNum = productOrderMapper.createOrder(order);
        return createNum;

    }

    @Override
    public void checkParams(Order order) {
        if(StringUtil.isBlank(order.getUserName())){
            throw new ApplicationException(ResultEnum.USER_NOT_NULL);
        }
        if(StringUtil.isBlank((order.getProductId()))){
            throw new ApplicationException(ResultEnum.PRODUCT_NOT_NULL);
        }
        if(order.getEntity()< 1){
            throw new ApplicationException(ResultEnum.ENTITY_NOT_EXISTS);
        }
    }

    @Override
    public List<Order> selectOrderBy(String user) {

        return productOrderMapper.selectOrder(user);
    }


}
