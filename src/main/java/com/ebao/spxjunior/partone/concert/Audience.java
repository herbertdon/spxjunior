package com.ebao.spxjunior.partone.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by dondavid on 17/6/27.
 */
@Aspect
public class Audience {
    @Pointcut("execution(** com.ebao.spxjunior.partone.concert.Performance.perform(..))")
    public void performance(){}

/*    @Before("performance()")
    public void silenceCellphones(){
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP!CLAP!CLAP!");
    }

    @AfterThrowing("performance()")
    public void demand(){
        System.out.println("Demanding a refund");
    }*/

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        System.out.println("Silencing cell phones");
        System.out.println("Taking seats");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Demanding a refund");
        }
        System.out.println("CLAP! CLAP! CLAP!");
    }
}
