package com.spring.boot.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

@Service
public class BeanLifeApp implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean
{

    private String name;

    public String getName() {
        return name;
    }

    public BeanLifeApp() {
        System.out.println("Bean Life App Constructor is called");
    }

    @Autowired
    private Triangle triangle;

    @Autowired
    private ShapeService shapeService;

    /***** Aware Interfaces Methods *****/
    @Override
    public void setBeanName(String s) {
        System.out.println("Set Bean Method is called and bean name is: " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Set Bean Factory Method is called for Bean Factory which is Singleton = " +
                beanFactory.isSingleton("beanLifeApp"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Set Application Context Method is called and Beans available are : " +
                Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        /*System.out.println("Post Process Before Initialization Method is called on bean: " + beanName);*/
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       /* System.out.println("Post Process After Initialization Method is called on bean: " + beanName);*/
        return bean;
    }

    /**** Here the class properties are set with value */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties Set Method is called and Properties are set for " + triangle.toString()
        + " And " + shapeService.toString());
        name = "Vedika";
    }

    @PostConstruct
    public void setValues() {
        System.out.println("Called Post Construct set values method");
        name = "Tushar";
    }

    @PreDestroy
    private void shutdown() {
        System.out.println("Shutdown All Resources");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying Bean");
    }
}

/**** Once properties are set, container calls method with @PostConstruct annotation to initialize anything specific
 * After that after properties set method is called.
 *
 * init-method is another alternative to @PostConstruct when you are using XML configuration.
 *
 * JSR - 250 added @PostConstruct annotation.
 */
