package com.markus.spring.aop.feature.blog.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: markus
 * @date: 2022/12/1 1:27 PM
 * @Description: 横切点表达式使用演示
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
public class AspectJPointcutExpressionConfig {
    // 表示 方法的访问类型为public 任意返回类型 任意类型的specialReferenceDemo方法 参数可有可无
    @Pointcut(value = "execution(public * *.specialReferenceDemo(..))")
    public void executionPointcut() {

    }

    // 表示 匹配在com.markus.spring.aop.feature.blog子模块下的方法
    @Pointcut(value = "within(com.markus.spring.aop.feature.blog.domain.*)")
    public void withinPointcut() {
    }

    // 表示 匹配目标对象是com.markus.spring.aop.feature.blog.domain.DefaultPointcutDemo下的方法
    @Pointcut(value = "target(com.markus.spring.aop.feature.blog.domain.DefaultPointcutDemo)")
    public void targetPointcut() {

    }

    // 表示 匹配代理对象是com.markus.spring.aop.feature.blog.domain.PointcutDemo下的方法
    @Pointcut(value = "this(com.markus.spring.aop.feature.blog.domain.PointcutDemo)")
    public void thisPointcut(){

    }

    // 表示 匹配的方法中参数是String类型
    @Pointcut(value = "args(com.markus.spring.aop.feature.blog.domain.ArgsDemo)")
    public void argsPointcut(){

    }

    // 表示 匹配被@EchoInterface定义的对象下的方法
    // 它是动态匹配的，会为所有目标对象生成代理，所以慎用！例如AOP动态代理通过cglib实现，遇到被final修饰的bean对象，就会抛出异常
    @Pointcut(value = "@target(com.markus.aop.overview.annotation.EchoInterface)")
    public void atTargetPointcut(){

    }

    // 表示 匹配被@EchoInterface定义的对象下的方法
    // 与@target不同，它是属于静态匹配，描述为定义方法的对象被@EchoInterface注释
    @Pointcut(value = "@within(com.markus.aop.overview.annotation.EchoInterface)")
    public void atWithinPointcut(){

    }

    // 表示 匹配参数所属的类型被@EchoInterface注释的所有方法
    @Pointcut(value = "@args(com.markus.aop.overview.annotation.EchoInterface)")
    public void atArgsPointcut(){

    }

    // 表示 匹配被@EchoInterface注释的所有方法
    @Pointcut(value = "@annotation(com.markus.aop.overview.annotation.EchoInterface)")
    public void atAnnotationPointcut(){

    }


    @Before("executionPointcut()")
    public void executionPointcutBefore() {
        System.out.println("this is execution pointcut");
    }

    @Before("withinPointcut()")
    public void withinPointcutBefore() {
        System.out.println("this is within pointcut");
    }

    @Before("targetPointcut()")
    public void targetPointcutBefore(){
        System.out.println("this is target pointcut");
    }

    @Before("thisPointcut()")
    public void thisPointcutBefore(){
        System.out.println("this.is this pointcut");
    }

    @Before("argsPointcut())")
    public void argsPointcutBefore(){
        System.out.println("this is args pointcut");
    }

    @Before("atTargetPointcut()")
    public void atTargetPointcutBefore(){
        System.out.println("this is @target pointcut");
    }

    @Before("atWithinPointcut()")
    public void atWithinPointcutBefore(){
        System.out.println("this is @within pointcut");
    }

    @Before("atArgsPointcut()")
    public void atArgsPointcutBefore(){
        System.out.println("this is @args pointcut");
    }

    @Before("atAnnotationPointcut()")
    public void atAnnotationPointBefore(){
        System.out.println("this is @annotation pointcut");
    }
}
