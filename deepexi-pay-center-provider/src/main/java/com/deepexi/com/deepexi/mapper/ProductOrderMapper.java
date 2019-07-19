package com.deepexi.com.deepexi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.com.deepexi.domain.eo.Order;
import com.deepexi.com.deepexi.domain.eo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductOrderMapper extends BaseMapper<Order> {


    Integer createOrder(@Param("order") Order order);


    List<Order> selectOrder(@Param("user") String user);



}
