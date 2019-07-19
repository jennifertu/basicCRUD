package com.deepexi.com.deepexi.domain.eo;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.ws.rs.QueryParam;

@TableName("orderDetails")
public class Delivery extends SuperEntity {

    @QueryParam("customerId")
    private String customerId;

    @QueryParam("address")
    private String address;

    @QueryParam("telephone")
    private String telephone;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
