package com.markus.spring.spring.bean.lifecycle.other.bean;

/**
 * @author: markus
 * @date: 2022/5/5 5:49 下午
 * @Description:
 * @Blog: http://markuszhang.com/
 */
public class People {
    private Person person;

    public People() {
    }

    public People(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "People{" +
                "person=" + person +
                '}';
    }
}
