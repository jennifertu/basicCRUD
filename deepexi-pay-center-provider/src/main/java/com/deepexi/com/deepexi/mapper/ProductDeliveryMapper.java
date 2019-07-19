package com.deepexi.com.deepexi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.com.deepexi.domain.eo.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jennifertu1014
 */
@Mapper
public interface ProductDeliveryMapper extends BaseMapper<Delivery> {


    Integer createDelivery(@Param("delivery") Delivery delivery);

}
