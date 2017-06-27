package com.ebao.spxjunior.partone.concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by dondavid on 17/6/27.
 */
@Aspect
public class Audience {
    /*@Pointcut("execution(** com.ebao.spxjunior.partone.concert.Performance.perform(..))")
    public void performance(){}


    public void silenceCellphones(){}*/

    @Before("execution(** com.ebao.spxjunior.partone.concert.Performance.perform(..))")
    public void silenceCellphones(){
        System.out.println("Silencing cell phones");
    }


    @Before("execution(** com.ebao.spxjunior.partone.concert.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(** com.ebao.spxjunior.partone.concert.Performance.perform(..))")
    public void applause(){
        System.out.println("CLAP!CLAP!CLAP!");
    }

    @AfterThrowing("execution(** com.ebao.spxjunior.partone.concert.Performance.perform(..))")
    public void demand(){
        System.out.println("Demanding a refund");
    }


}
