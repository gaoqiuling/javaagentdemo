package com.itisacat.rpc.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class InitRpcConfig implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    public static Map<String, Object> rpcServices = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(Service.class);
        for (Object bean : beans.values()) {
            Class<?> clazz = bean.getClass();
            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> inter : interfaces) {
                rpcServices.put(getClassName(inter.getName()),bean);
                log.info("已经加载的服务:"+inter.getName());
            }
        }
    }

    private String getClassName(String beanClassName){
        String className = beanClassName.substring(beanClassName.lastIndexOf(".")+1);
        className = className.substring(0,1).toLowerCase() + className.substring(1);
        return className;
    }
}
