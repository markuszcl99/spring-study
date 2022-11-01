package com.markus.aop.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: markus
 * @date: 2022/10/18 9:02 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Component
public abstract class AbstractService {
    @Autowired
    Dao dao;
}
