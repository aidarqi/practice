package com.aidar.serializable_test;

import java.io.Serializable;

/**
 * @desc
 * @date 17-7-12
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private String email;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
