package com.anime.api.animejavaapi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Aspect
public class AspectConfig {

    Logger LOG = LoggerFactory.getLogger(getClass());

  /* @Before(value = "execution(* com.anime.api.animejavaapi.controller.*.*(..))")
    //  Intercepts methods before execution
    public void before(JoinPoint joinPoint){
        LOG.info("Inside Before Advice");
    } */


   /* @Before(value = "execution(* com.anime.api.animejavaapi.controller.*.*(..)) && args(object)")
    //Intercepts methods before execution - Object because in controller i have differect data types for params - args(object1,object2) ecc..
    public void beforeWithArgs(JoinPoint joinPoint, Object object) {
        LOG.info("Inside Before Advice");
    }*/

    /*@After(value = "execution(* com.anime.api.animejavaapi.controller.*.*(..)) && args(object)")
    //After the methods call aspect
    public void after(JoinPoint joinPoint, Object object) {
        LOG.info("Inside After Advice");
        LOG.info("Object = " + object);
    }*/


   /* @AfterReturning(value = "execution(* com.anime.api.animejavaapi.controller.*.*(..)) && args(object)", returning = "returningObj")
    //After the methods call aspect and returning obj (response from the controller)
    public void afterReturningAdvice(JoinPoint joinPoint, Object object, Object returningObj) {
        LOG.info("Inside AfterReturning Advice");
        LOG.info("Object = " + object);
        LOG.info("Returning Object Response = " + returningObj);
    }*/

    @Around(value = "execution(* com.anime.api.animejavaapi.controller.*.*(..)) && args(object)")
    //Combinations with Before and After so Request -> methods -> Response
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Object object) throws Throwable {
        LOG.info("Inside Around Advice");
        LOG.info("Request = " + object);
        Object returningObj = proceedingJoinPoint.proceed(); //this object is basically the response intercepted
        LOG.info("Response = " + returningObj);
    }

}
