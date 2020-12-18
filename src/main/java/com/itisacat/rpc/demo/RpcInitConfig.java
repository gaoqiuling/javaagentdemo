package com.itisacat.rpc.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class RpcInitConfig implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, BeanFactoryAware {
    private ResourceLoader resourceLoader;
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MyClassPathBeanDefinitionScanner scanner = new MyClassPathBeanDefinitionScanner(registry, false);
        scanner.setResourceLoader(resourceLoader);
        scanner.registerFilters();
        Set<BeanDefinitionHolder> beanDefinitionSet = scanner.doScan("com.itisacat.rpc.demo");
        for (BeanDefinitionHolder beanDefinition : beanDefinitionSet) {
            String beanName = beanDefinition.getBeanName();
            //将RpcClient的工厂类注册进去
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(RpcClientFactoryBean.class);
            GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
            genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanDefinition().getBeanClassName());
            genericBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
            //将其注册进容器中
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        }
    }
}
