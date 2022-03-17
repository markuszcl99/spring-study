package com.markus.spring.spring.dependency.lookup.hierarchical;

import com.markus.spring.ioc.container.annotation.Super;
import com.markus.spring.ioc.container.domain.SuperUser;
import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author: markus
 * @date: 2022/3/17 9:24 下午
 * @Description: 层次性依赖查找 示例
 * @Blog: http://markuszhang.com/
 */
public class HierarchicalBeanFactoryLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalBeanFactoryLookupDemo.class);
        applicationContext.refresh();

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        HierarchicalBeanFactory parentBeanFactory = createHierarchicalBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);

        User user = BeanFactoryUtils.beanOfTypeIncludingAncestors(beanFactory, SuperUser.class);
        System.out.println("【单一类型查找Bean实例列表】: "+user);

        Map<String,User> beanMaps = BeanFactoryUtils.beansOfTypeIncludingAncestors(beanFactory,User.class);
        System.out.println("【集合类型查找Bean实例列表】: "+beanMaps);

        String[] beanNamesWithAnnotation = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(beanFactory, Super.class);
        System.out.print("【根据Java注解类型查找Bean名称列表】: {");
        for (String beanName : beanNamesWithAnnotation) {
            System.out.print(beanName+",");
        }
        System.out.println("}");

        applicationContext.close();
    }

    private static HierarchicalBeanFactory createHierarchicalBeanFactory(){
        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(parentBeanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");
        return parentBeanFactory;
    }
}
