package com.deepexi.com.deepexi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.com.deepexi.domain.dto.DeliveryDto;
import com.deepexi.com.deepexi.domain.dto.ProductDto;
import com.deepexi.com.deepexi.domain.eo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by donh on 2018/7/24.
 * author:tulinyao
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> selectPageVo(@Param("price") Integer price);

    /**
     * 通过商品id集合批量查询商品信息
     *
//     * @param spcProductDto
     * @return
     */
//    List<ProductDto> getProductInfoByIds(@Param("list") List<ProductDto> spcProductDto);
//
//    /**
//     * 查询所有商品信息
//     *
//     * @return
//     */
//    List<ProductDto> findProductInfo();
//
//    List<Product> selectPage(@Param("price") Integer price);

    //返回类似于这个名字的product
    List<Product> selectList1(@Param("name") String name);


    Integer updateById1(@Param("product") Product product);


    List<DeliveryDto> findAllDeliveriesByProductId(@Param("id") String id);
}
