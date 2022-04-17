package com.markus.spring.spring.bean.lifecycle.parse;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @author: markus
 * @date: 2022/3/29 11:48 下午
 * @Description: BeanDefinition解析 示例
 * @Blog: http://markuszhang.com/
 */
public class AnnotatedBeanDefinitionParseDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

//        BeanDefinitionParser parser spring xml扩展时会介绍，此时先不用
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beanDefinitionCountBeforeRegister = beanFactory.getBeanDefinitionCount();
        beanDefinitionReader.register(AnnotatedBeanDefinitionParseDemo.class);
        int beanDefinitionCountAfterRegister = beanFactory.getBeanDefinitionCount();

        System.out.println("已加载Bean数量：" + (beanDefinitionCountAfterRegister - beanDefinitionCountBeforeRegister));

        AnnotatedBeanDefinitionParseDemo demo = beanFactory.getBean("beanDefinitionParseDemo", AnnotatedBeanDefinitionParseDemo.class);
        System.out.println(demo);
    }
}
