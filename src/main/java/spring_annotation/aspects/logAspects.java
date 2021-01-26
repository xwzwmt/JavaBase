package spring_annotation.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logAspects {
    //前置通知
    @Before("execution(* spring_annotation.service.impl.*.*(..))")
    public void before(){
        System.out.println("前置通知");
    }

    @After("execution(* spring_annotation.service.impl.*.*(..))")
    public void after(){
        System.out.println("后置通知");
    }

    @AfterThrowing("execution(* spring_annotation.service.impl.*.*(..))")
    public void afterThrowing(){
        System.out.println("后置异常通知");
    }
    @AfterReturning("execution(* spring_annotation.service.impl.*.*(..))")
    public void afterReturning(){
        System.out.println("后置返回通知");
    }
}
