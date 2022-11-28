package com.markus.spring.aop.feature.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: markus
 * @date: 2022/11/5 1:10 PM
 * @Description: AspectJ Pointcut 指令与表达式 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
public class AspectJPointcutConfig {
    /**
     * execution : For matching method execution join points. This is the primary pointcut designator to use when working with Spring AOP.
     * 用于匹配方法执行连接点，这是使用Spring AOP时使用的主要切入点指示符
     */
    @Pointcut(value = "execution(public * * (..))")
    public void executionPointcut() {
    }

    /**
     * within : Limits matching to join points within certain types (the execution of a method declared within a matching type when using Spring AOP).
     * 将匹配限制为某个类型中的连接点，使用Spring AOP时，在一个匹配类型中声明的方法的执行
     * 白话：进行模块限制，可用通配符
     */
    @Pointcut(value = "within(com.markus.aop.overview..*)")
    public void withinPointcut() {
    }

    /**
     * this : Limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type.
     * 限制对连接点的匹配(使用Spring AOP时方法的执行)，其中bean引用(Spring AOP代理)是给定类型的实例。
     * this更常用于绑定形式，表达式需要指定具体的类型，不能用通配符
     */
    @Pointcut(value = "this(com.markus.aop.overview.DefaultEchoService)")
    public void thisPointcut() {
    }

    /**
     * target : Limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type.
     * 限制与连接点的匹配(使用Spring AOP时方法的执行)，其中目标对象(被代理的应用程序对象)是给定类型的实例。
     * target更常用于绑定形式，表达式需要指定具体的类型，不能使用通配符
     */
    @Pointcut(value = "target(com.markus.aop.overview.EchoService)")
    public void targetPointcut() {
    }

    /**
     * args : Limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types.
     * 限制对连接点的匹配(使用Spring AOP时方法的执行)，其中参数是给定类型的实例。
     */
    @Pointcut(value = "args(String)")
    public void argsPointcut() {
    }

    /**
     * @target : Limits matching to join points (the execution of methods when using Spring AOP) where the class of the executing object has an annotation of the given type.
     * 限制对连接点的匹配(使用Spring AOP时的方法执行)，其中执行对象的类具有给定类型的注解。
     * 白话: 目标对象具有该注解
     */
    @Pointcut(value = "@target(com.markus.aop.overview.annotation.EchoInterface)")
    public void atTargetPointcut() {
    }

    /**
     * @args : Limits matching to join points (the execution of methods when using Spring AOP) where the runtime type of the actual arguments passed have annotations of the given types.
     * 限制对连接点的匹配(使用Spring AOP时方法的执行)，其中传递的实际参数的运行时类型具有给定类型的注解。
     * 白话: 目标对象的方法中参数类型具有指定的注解，则该方法可以被代理
     */
    @Pointcut(value = "@args(com.markus.aop.overview.annotation.EchoInterface)")
    public void atArgsPointcut() {
    }

    /**
     * @within : Limits matching to join points within types that have the given annotation (the execution of methods declared in types with the given annotation when using Spring AOP).
     * 限制对具有给定注解的类型中的连接点的匹配(在使用Spring AOP时，使用给定注解在类型中声明的方法的执行)。
     * 白话: 目标对象具有给定的注解，目标对象的方法均会被代理
     */
    @Pointcut(value = "@within(com.markus.aop.overview.annotation.EchoInterface)")
    public void atWithinPointcut() {
    }

    /**
     * @annotation : Limits matching to join points where the subject of the join point (the method being run in Spring AOP) has the given annotation.
     * 限制对连接点的主题(在Spring AOP中运行的方法)具有给定注解的连接点的匹配。
     */
    @Pointcut(value = "@annotation(com.markus.aop.overview.annotation.EchoInterface)")
    public void atAnnotationPointcut() {
    }

    @Before("withinPointcut()")
    public void beforeWithin() {
        System.out.println("@Before from withinPointcut ...");
    }

    @Before("thisPointcut()")
    public void beforeThis() {
        System.out.println("@Before from thisPointcut ...");
    }

    @Before("targetPointcut()")
    public void beforeTarget() {
        System.out.println("@Before from targetPointcut ...");
    }

    @Before("argsPointcut()")
    public void beforeArgs() {
        System.out.println("@Before from argsPointcut ...");
    }

    @Before("atTargetPointcut()")
    public void beforeAtTarget() {
        System.out.println("@Before from atTargetPointcut ...");
    }

    @Before("atArgsPointcut()")
    public void beforeAtArgs() {
        System.out.println("@Before from atArgsPointcut ...");
    }

    @Before("atWithinPointcut()")
    public void beforeAtWithin() {
        System.out.println("@Before from atWithinPointcut ...");
    }

    @Before("atAnnotationPointcut()")
    public void beforeAtAnnotation() {
        System.out.println("@Before from atAnnotationPointcut ...");
    }


    // TODO 为什么在DefaultEchoService没有加@EchoInterface注解但EchoService加了@EchoInterface注解的情况下，目标对象方法的调用不会被AOP代理呢？
}
