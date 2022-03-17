package com.markus.spring.spring.dependency.lookup.hierarchical;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/17 8:39 下午
 * @Description: 层次性依赖查找（自定义） 示例
 * @Blog: http://markuszhang.com/
 */
public class HierarchicalBeanFactoryCustomerLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalBeanFactoryCustomerLookupDemo.class);
        applicationContext.refresh();

        // 1. 获取HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        HierarchicalBeanFactory parentHierarchicalBeanFactory = createHierarchicalBeanFactory();
        beanFactory.setParentBeanFactory(parentHierarchicalBeanFactory);

        displayContainsLocalBean(beanFactory,"user");
        displayContainsLocalBean(parentHierarchicalBeanFactory,"user");

        displayContainsBean(beanFactory,"user");
        displayContainsBean(parentHierarchicalBeanFactory,"user");


        applicationContext.close();
    }

    private static HierarchicalBeanFactory createHierarchicalBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");
        return beanFactory;
    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory,String beanName){
        System.out.printf("当前 BeanFactory[%s] 是否包含 Local Bean[name : %s] : %s\n",beanFactory,beanName,beanFactory.containsLocalBean(beanName));
    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory,String beanName){
        System.out.printf("当前 BeanFactory[%s] 是否包含 Bean[name : %s] : %s\n",beanFactory,beanName,containsBean(beanFactory,beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory,String beanName){
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (containsBean(parentHierarchicalBeanFactory,beanName)){
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }
}
