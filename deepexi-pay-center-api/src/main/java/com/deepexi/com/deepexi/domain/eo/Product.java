package com.deepexi.com.deepexi.domain.eo;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.ws.rs.QueryParam;




public class Product extends SuperEntity {

    @QueryParam("name")
    private String name;

    @QueryParam("price")
    private Integer price;


    public Product() {}

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}

