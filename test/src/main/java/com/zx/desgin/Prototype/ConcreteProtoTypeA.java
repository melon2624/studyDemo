package com.zx.desgin.Prototype;

import java.util.List;

/**
 * @author zhangxin
 * @date 2022/9/14 16:36
 */
public class ConcreteProtoTypeA implements Prototype {

    private int age;
    private String name;
    private List hobbies;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public ConcreteProtoTypeA clone() {
        ConcreteProtoTypeA concreteProtoTypeA = new ConcreteProtoTypeA();
        concreteProtoTypeA.setAge(this.age);
        concreteProtoTypeA.setName(this.name);
        concreteProtoTypeA.setHobbies(this.hobbies);
        return concreteProtoTypeA;
    }
}
