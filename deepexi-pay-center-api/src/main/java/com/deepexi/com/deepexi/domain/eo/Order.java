package com.deepexi.com.deepexi.domain.eo;

import javax.ws.rs.QueryParam;

public class Order extends SuperEntity{

    @QueryParam("userName")
    private String userName;

    @QueryParam("entity")
    private Integer entity;

    @QueryParam("productId")
    private String productId;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
