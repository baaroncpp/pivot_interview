package com.interview.client.model;

import java.io.Serializable;

/**
 * @author bkaaron
 * @created 21/09/2022
 * @project pivot_int
 */

public class TestUser implements Serializable {
    private String name;
    private String address;
    private int age;

    public TestUser(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
