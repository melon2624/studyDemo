package com.zx.java8.entity;

import java.util.Objects;

/**
 * @author： zhangxin
 * @date： 2021-06-26 18:18
 */
public class UserEntity {

    private String userName;

    public UserEntity(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof UserEntity)
       return userName.equals(((UserEntity)o).userName)&&age==((UserEntity)o).age;
        else return false;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(userName, age);
//    }
}
