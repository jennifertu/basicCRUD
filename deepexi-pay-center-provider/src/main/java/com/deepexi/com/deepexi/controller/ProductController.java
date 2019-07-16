package com.deepexi.com.deepexi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deepexi.com.deepexi.domain.dto.ProductDto;
import com.deepexi.com.deepexi.domain.eo.Product;
import com.deepexi.com.deepexi.service.ProductService;
import com.deepexi.util.StringUtil;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.jboss.resteasy.annotations.Form;
import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jennifertu1014
 */
@Service
@Path("/api/v1/products")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Api("商品相关api")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @POST
    @Path("/create")
    public int createProduct(Product product){
        int createNum = productService.createProduct(product);
        System.out.println("we have created" + createNum + "product");
        return createNum;
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9]+}")
    public void deleteProduct(@PathParam("id") String id){
        productService.deleteProductById(id);
        System.out.println("you have deleted product " + id);
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Product updateProductById(@PathParam("id")String id, Product product){
        product.setId(id);
        if(StringUtils.isNotBlank(product.getName())){
            product.setName(product.getName());
        }
        else if(product.getPrice()>0){
            product.setPrice(product.getPrice());
        }
        System.out.println("product" + product.getId() + " has been changed");
        productService.updateProduct(product);
        return product;
    }

    @GET
    @Path("/detail")
    public Payload getProductById(@QueryParam("id") String id){
        productService.getProductById(id);
        System.out.println("get product" +id);
        return new Payload<>(productService.getProductById(id));

    }

    @GET
    @Path("/wrapper")
    public List<Product> selectByWrapper(@QueryParam("name")String name){
        List<Product> products = productService.selectByWrapper(name);
        return products;
    }

    @GET
    @Path("/select")
    public List<Product> condition(@QueryParam("name")String name, @QueryParam("price")Integer price){
        List<Product> products = productService.condition(name,price);
        return products;
    }

    @GET
    @Path("/querywrapper")
    public List<Product> selectByWrapperAlleq(@QueryParam("name") String name, @QueryParam("price") Integer price){
        List<Product> products = productService.selectByWrapperAlleq(name,price);
        return products;
    }






}