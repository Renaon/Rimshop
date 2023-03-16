package com.example.Rimshop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class ProductAspect {
    private long start;
    private long end;

    private Logger log = Logger.getLogger(ProductAspect.class.getName());

    @Pointcut("execution(* com.example.Rimshop.service.ProductService.addProduct(..))")
    public void StringProcessingAddProduct() {
        log.info("Время добавления продукта: " + (end-start));
    }

    @Before("StringProcessingAddProduct()")
    private void beforeAdd(){
        this.start = System.currentTimeMillis();
    }

    @After("StringProcessingAddProduct()")
    private void afterAdd() {
        this.end = System.currentTimeMillis();
    }
}
