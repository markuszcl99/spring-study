package com.markus.spring.spring.dependency.injection;

import com.markus.spring.ioc.container.domain.User;
import com.markus.spring.spring.dependency.injection.annotation.InjectUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.*;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * @author: markus
 * @date: 2022/3/21 1:47 下午
 * @Description: 注解驱动 依赖注入的处理过程分析
 * @Blog: http://markuszhang.com/
 */
public class AnnotationDependencyInjectionRevolutionDemo {

//    @Autowired          // 依赖查找（处理）+ 延迟处理
//    @Lazy
//    private User lazyUser;  // DependencyDescriptor ->

    @Autowired          // 依赖查找（处理）
    private User user;  // DependencyDescriptor ->
    // 必须（required=true）
    // 实时注入（eager=true）
    // 通过类型（User.class）
    // 字段名称（"user"）
    // 是否首要（primary=true）


    @Inject
    private User injectUser;

    @InjectUser
    private User myInjectUser;

    @Autowired          // 集合类型的依赖注入
    private Map<String, User> users; // user superUser


//    @Autowired
//    private Optional<User> userOptional;// superUser

    /**
     * 如果用static修饰就会注入成功，否则就会注入失败
     * 对比BeanDefinition的不同，加了static factoryBeanName为null，不加static factoryBeanName为外围类的全路径。
     * 如果不加static的话，会提前初始化外围类，此时spring还不认识@Autowired等注解 所以注入的字段为空
     * 底层原理是：
     * ConstructorResolver#instantiateUsingFactoryMethod方法 有个判断逻辑 if (factoryBeanName != null) 提前初始化工厂Bean  else 标注静态方法
     *
     * @return
     */
//    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
//        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        Set<Class<? extends Annotation>> autowiredAnnotationTypes =
//                new LinkedHashSet<>(Arrays.asList(Autowired.class, Inject.class, InjectUser.class));
//        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
//        return beanPostProcessor;
//    }
    @Bean
//    @Order(Ordered.LOWEST_PRECEDENCE - 3)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setAutowiredAnnotationType(InjectUser.class);
        // 决定AbstractBeanFactory#beanPostProcessors 的先后顺序 值越大，优先级越低
        beanPostProcessor.setOrder(Ordered.LOWEST_PRECEDENCE-1);
        return beanPostProcessor;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyInjectionRevolutionDemo.class);

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String resourcePath = "classpath:/META-INF/dependency-lookup.xml";
        reader.loadBeanDefinitions(resourcePath);

        applicationContext.refresh();

        AnnotationDependencyInjectionRevolutionDemo demo = applicationContext.getBean(AnnotationDependencyInjectionRevolutionDemo.class);
        System.out.println("demo.user = " + demo.user);
        System.out.println("demo.injectUser = " + demo.injectUser);
//        System.out.println(demo.user == demo.injectUser);
        System.out.println("demo.myInjectUser = " + demo.myInjectUser);
        System.out.println("demo.users = " + demo.users);
//        System.out.println("demo.userOptional = " + demo.userOptional);
//        System.out.println("demo.lazyUser = " + demo.lazyUser);

        applicationContext.close();
    }
}
