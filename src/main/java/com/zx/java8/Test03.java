package com.zx.java8;

import com.zx.java8.entity.UserEntity;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author： zhangxin
 * @date： 2021-06-26 18:19
 */
public class Test03 {
    public static void main(String[] args) {

        ArrayList<UserEntity> arrayList=new ArrayList<>();
            arrayList.add(new UserEntity("zx",23));
            arrayList.add(new UserEntity("zm",18));
            arrayList.add(new UserEntity("jy",24));
            /*arrayList.sort(new Comparator<UserEntity>() {
                @Override
                public int compare(UserEntity o1, UserEntity o2){
                    return  o1.getAge()-o2.getAge();
                }
            });*/
            arrayList.sort((o1,o2)->{
                return o1.getAge()-o2.getAge();
            });

            arrayList.forEach((userEntity)->{
            System.out.println(userEntity.toString());
        });

            new Thread(() -> System.out.println(Thread.currentThread().getName()+"zx"));

    }
}
