package com.markus.aop.overview;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author: markus
 * @date: 2022/10/18 9:04 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Configuration
public class AutowireDemoTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.markus.aop.overview");
        applicationContext.register(AutowireDemoTest.class);

        applicationContext.refresh();

        ConcreteService concreteService = applicationContext.getBean(ConcreteService.class);
        concreteService.print();

        applicationContext.close();
    }

    @Bean("dao")
    public Dao dao() {
        Dao dao = new Dao();
        dao.setId(1);
        dao.setName("markus");
        return dao;
    }
}
