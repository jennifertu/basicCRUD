package com.deepexi.com.deepexi.controller;


import com.deepexi.com.deepexi.domain.eo.Order;
import com.deepexi.com.deepexi.domain.eo.Product;
import com.deepexi.com.deepexi.service.ProductOrderService;
import com.deepexi.com.deepexi.service.ProductService;
import com.deepexi.util.StringUtil;
import com.deepexi.util.constant.ContentType;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.ws.rs.*;
import java.util.List;

/**
 * @author jennifertu1014
 */
@Service
@Path("/api/v1/orders")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Api("商品相关api")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductOrderService productOrderService;

    @POST
    @Path("/createOrder")
    public int createOrder(Order order){
        productOrderService.checkParams(order);
        int createNum = productOrderService.createOrder(order);
        System.out.println("we have created" + order);
        return createNum;
    }

    @GET
    @Path("/selectOrders")
    public List<Order> selectOrderBy(@QueryParam("user") String user){
        return productOrderService.selectOrderBy(user);

    }



}
