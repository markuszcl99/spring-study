package com.markus.spring.spring.bean.lifecycle.other;

import com.markus.spring.ioc.container.domain.User;
import com.markus.spring.spring.bean.lifecycle.other.bean.LifeCycleBean;
import com.markus.spring.spring.bean.lifecycle.other.bean.People;
import com.markus.spring.spring.bean.lifecycle.other.bean.Person;
import com.markus.spring.spring.bean.lifecycle.other.processor.MyBeanFactoryPostProcessor;
import com.markus.spring.spring.bean.lifecycle.other.processor.MyInstantiationAwareBeanPostProcessor;
import com.markus.spring.spring.bean.lifecycle.other.server.PersonService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author: markus
 * @date: 2022/5/4 10:42 上午
 * @Description: Spring Bean生命周期 外部文章示例
 * @Blog: http://markuszhang.com/
 */
@Configuration // 此注解的Bean会被cglib增强
public class BeanLifeCycle {
    public static void main(String[] args) {
        // 1. 元信息配置
        //      1.1 (xml)
//        metaConfigStage4Xml();
        //      1.2 (properties)
//        metaConfigStage4Properties();
        //      1.3 (annotation)
//        metaConfigStage4Annotation();
        // 2. BeanDefinition合并
//        mergeBeanDefinition();
        // 3. 实例化前阶段
//        instantiationBefore();
        // 4. 实例化阶段
        createInstance();
    }

    private static void createInstance() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/bean-life-cycle.xml";
        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("bean definition count is = " + beanDefinitionCount);

        People people = beanFactory.getBean("people", People.class);
        System.out.println(people);
    }

    private static void instantiationBefore() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/bean-life-cycle.xml";
        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("bean definition count is = " + beanDefinitionCount);

        LifeCycleBean lifeCycleBean = beanFactory.getBean("lifeCycleBean", LifeCycleBean.class);
        System.out.println(lifeCycleBean);
    }

    private static void mergeBeanDefinition() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/bean-life-cycle.xml";
        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("bean definition count is = " + beanDefinitionCount);

//        People people = beanFactory.getBean("people", People.class);
//        System.out.println(people);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }

    private static void metaConfigStage4Annotation() {
        // 采用注解驱动上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册组件
        context.register(BeanLifeCycle.class);
        // 扫描组件
        context.scan("com/markus/spring/spring/bean/lifecycle/other/server");
        // 启动应用上下文
        context.refresh();

        // 依赖查找
        System.out.println(context.getBean(BeanLifeCycle.class));
        System.out.println(context.getBean(PersonService.class));

        // 关闭应用上下文
        context.close();
    }

    private static void metaConfigStage4Properties() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        // 乱码原因：properties文件默认编码方式是ISO-8859-1,解码时采用了UTF-8所以会产生乱码
//        String location = "classpath:/META-INF/user.properties";
//        beanDefinitionReader.loadBeanDefinitions(location);
        // 正确方式
        String location = "META-INF/user.properties";// 格式路径为约定方式，如果增加 "classpath:/" 会抛出文件未找到的异常
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        beanDefinitionReader.loadBeanDefinitions(encodedResource);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }

    private static void metaConfigStage4Xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/bean-life-cycle.xml";
        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("bean definition count is = " + beanDefinitionCount);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }


    private static void beanLifeCycle() {
        System.out.println("开始初始化容器");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-life-cycle.xml");

        System.out.println("容器初始化完成");

        Person person = context.getBean(Person.class);
        System.out.println(person);

        System.out.println("容器即将关闭");
        context.close();
        System.out.println("容器关闭完成");
    }
}
