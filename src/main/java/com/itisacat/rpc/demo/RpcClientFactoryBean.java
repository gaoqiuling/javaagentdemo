package com.itisacat.rpc.demo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;


public class RpcClientFactoryBean implements FactoryBean {
    @Autowired
    private RpcCglibProxy rpcCglibProxy;
    private Class<?> classType;

    public RpcClientFactoryBean(Class<?> classType) {
        this.classType = classType;
    }

    @Override
    public Object getObject() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(classType);
        enhancer.setCallback(rpcCglibProxy);
        return enhancer.create();
    }

    @Override
    public Class<?> getObjectType() {
        return this.classType;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
