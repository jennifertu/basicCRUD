package com.deepexi.com.deepexi.enums;

import com.deepexi.util.constant.BaseEnumType;

/**
 * Created by donh on 2019/1/8.
 */
public enum ResultEnum implements BaseEnumType{
    UNKNOWN_ERROR("500", "系统出异常啦!请联系管理员!!!"),
    SUCCESS("200", "success"),
    USER_EXIST("100002", "用户已存在！"),
    NETWORK_LIMIT("100001", "网络限流！"),
    TOKEN_NOT_FOUND("200001", "token不能为空！"),
    TENANT_NOT_FOUND("200002", "tenantId不能为空！"),
    RPC_ERROR("300000", "RPC调用异常!请检查服务是否正常!!!"),
    USER_NOT_NULL("400","用户名不能为空"),
    PRODUCT_NOT_NULL("400","商品不能为空"),
    ENTITY_NOT_EXISTS("400","不合法的数量输入"),
    ADDRESS_NOT_NULL("400","用户地址不能为空"),
    TELEPHONE_NOT_NULL("400","用户电话不能为空");


    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}