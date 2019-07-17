package com.deepexi.com.deepexi.service;

import com.deepexi.util.extension.ApplicationException;
import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.com.deepexi.domain.eo.Product;

import java.util.List;


public interface ProductService {

    PageBean getProductList(Integer page, Integer size, Integer price);

    Product getProductById(String id);

    Integer createProduct(Product product);

    Boolean deleteProductById(String id);

    Integer updateProduct(Product product);

    void testError();

    void testRpcError() throws ApplicationException;

    List<Product> selectByWrapper(String name);

    List<Product> condition(String name, Integer price);

    List<Product> selectByWrapperAlleq(String name, Integer price);

    Integer updateProductByIdDefault(Product product);

    Product selectByIdDefault(String id);

    List<Product> selectByDescPrice();
}
