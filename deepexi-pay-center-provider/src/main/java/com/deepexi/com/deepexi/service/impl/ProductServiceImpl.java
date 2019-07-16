package com.deepexi.com.deepexi.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deepexi.com.deepexi.enums.ResultEnum;
import com.deepexi.com.deepexi.service.ProductService;
import com.deepexi.com.deepexi.domain.eo.Product;
import com.deepexi.com.deepexi.extension.AppRuntimeEnv;
import com.deepexi.com.deepexi.mapper.ProductMapper;
import com.deepexi.util.StringUtil;
import com.deepexi.util.extension.ApplicationException;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service(version = "${demo.service.version}")
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private ProductMapper productMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public PageBean getProductList(Integer page, Integer size, Integer age) {
        PageHelper.startPage(page, size);
        List<Product> userTasks = productMapper.selectPageVo(age);
        return new PageBean<>(userTasks);
    }

    @Override
    public Integer createProduct(Product product) {
        logger.info(",,,,,,,,,,,,,,");
        if(product.getName()!=null && product.getPrice()!= null){
            System.out.println("we are here");
            return productMapper.insert(product);
        }
        return 0;
    }

    @Override
    public Boolean deleteProductById(String id) {
        productMapper.deleteById(id);
        return true;
    }

    @Override
    public Integer updateProduct(Product product) {
        return productMapper.updateById1(product);
    }

    @Override
    @SentinelResource(value = "testSentinel", fallback = "doFallback", blockHandler = "exceptionHandler")
    public Product getProductById(String id) {
        // dubbo生产者被消费者调用时，客户端隐式传入的参数
        String tenantId = RpcContext.getContext().getAttachment("tenantId");
        logger.info("获取客户端隐式参数，tenantId：{}", tenantId);
        return productMapper.selectById(id);
    }


    @Override
    public List<Product> selectByWrapper(String name) {
       return productMapper.selectList1(name);
    }

    @Override
    public List<Product> condition(String name, Integer price) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<Product>();
        if(StringUtil.isNotEmpty(name)){
            queryWrapper.like("name",name);
        }
        List<Product> products =  productMapper.selectList(queryWrapper);
        return products;
    }

    @Override
    public List<Product> selectByWrapperAlleq(String name, Integer price) {
        QueryWrapper<Product> queryWrapper =  new QueryWrapper<Product>();
        Map<String,Object> params =  new HashMap<>();
        params.put("name",name);
        params.put("price",price);
        queryWrapper.allEq(params,true);
        //this selectlist method is defined by myBatis
        List<Product> productList =productMapper.selectList(queryWrapper);
        return productList;
    }


    public String doFallback(long i) {
        // Return fallback value.
        return "Oops, degraded";
    }

    /**
     * 熔断降级处理逻辑
     * @param s
     * @param ex
     * @return
     */
    public void exceptionHandler(long s, Exception ex) {
        // Do some log here.
        logger.info("-------------熔断降级处理逻辑---------\n");
        throw new ApplicationException(ResultEnum.NETWORK_LIMIT);
    }

    /**
     * 测试框架统一捕获处理内部处理异常
     */
    public void testError() {
        throw new ApplicationException(ResultEnum.USER_EXIST);
    }

    /**
     * 测试rpc调用时服务端抛出自定义异常，调用端是否能正常处理
     */
    public void testRpcError() {
        throw new ApplicationException(ResultEnum.RPC_ERROR);
    }


}