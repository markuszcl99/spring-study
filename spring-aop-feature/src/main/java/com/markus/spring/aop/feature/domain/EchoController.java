package com.markus.spring.aop.feature.domain;

import com.markus.aop.overview.EchoService;
import com.markus.aop.overview.annotation.EchoInterface;

/**
 * @author: markus
 * @date: 2022/11/5 2:45 PM
 * @Description: 参数携带注解 domain
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EchoInterface
public class EchoController {
    public void echo(@EchoInterface EchoService echoService) {
        System.out.println("echo controller parameter");
    }

    @EchoInterface
    public void echo() {
        System.out.println("echo controller method");
    }
}
