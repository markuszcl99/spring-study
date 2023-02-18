package com.markus.spring.injection;

import com.markus.spring.bean.User;
import com.markus.spring.bean.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2023/2/11 4:47 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Import({
        com.markus.spring.configuration.SameTypeBeanConfiguration.class
})
@ImportResource({
        "classpath:/META-INF/injection/autowire-bean-ctx.xml"
})
public class QualifierAnnotationUseDemo {

    @Autowired
    @Qualifier(value = "user1")
    private User user;

    @Autowired
    private User[] users;

    @Autowired
//    private ArrayList<User> userArrayList; // 会报错 因为解析依赖的时候不包括非接口的Collection类型
    private List<User> userArrayList;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(QualifierAnnotationUseDemo.class);
        context.refresh();

        QualifierAnnotationUseDemo demo = context.getBean(QualifierAnnotationUseDemo.class);
        System.out.println("demo.user : " + demo.user);

        UserHolder userHolder = context.getBean(UserHolder.class);
        System.out.println("userHolder.user : " + userHolder.getUser());

        System.out.println("demo.user == userHolder.user ? " + (demo.user == userHolder.getUser()));

        System.out.printf("demo.users : [");
        for (User user : demo.users) {
            System.out.print(user + ",");
        }
        System.out.println("]");

        System.out.println("demo.userArrayList : " + demo.userArrayList);

        context.close();
    }
}
