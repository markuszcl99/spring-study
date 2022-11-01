package com.markus.aop.overview;

/**
 * @author: markus
 * @date: 2022/10/18 9:02 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Dao {
    private int id;
    private String name;

    public Dao() {
    }

    public Dao(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
