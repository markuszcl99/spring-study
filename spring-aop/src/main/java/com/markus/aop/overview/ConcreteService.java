package com.markus.aop.overview;

import org.springframework.stereotype.Component;

/**
 * @author: markus
 * @date: 2022/10/18 9:06 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Component
public class ConcreteService extends AbstractService{
    public void print(){
        System.out.println(dao.toString());
    }
}
