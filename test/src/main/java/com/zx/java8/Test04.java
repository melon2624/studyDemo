package com.zx.java8;

import com.zx.java8.entity.UserEntity;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author： zhangxin
 * @date： 2021-06-26 19:18
 * List转Map
 * List转成Set
 * 计算求和
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<UserEntity> arrayList = new ArrayList<>();
        arrayList.add(new UserEntity("com/zx", 24));
        arrayList.add(new UserEntity("zm", 18));
        arrayList.add(new UserEntity("jy", 23));

        Map<String, UserEntity> map2 = arrayList.stream().collect(Collectors.toMap(userEntity -> userEntity.getUserName(), userEntity -> userEntity));

        map2.forEach((key, value) -> {
            System.out.println(key + "," + value);
        });
        //    ------------------------------------------------------
        UserEntity user1 = new UserEntity("com/zx", 24);
        UserEntity user2 = new UserEntity("com/zx", 26);
        UserEntity user3 = new UserEntity("zm", 18);
        UserEntity user4 = new UserEntity("jy", 23);


        System.out.println(user1.equals(user2));
        HashMap<Object, Object> map = new HashMap<>();
        map.put(user1, "a");
        map.put(user2, "b");
        map.forEach((k, v) -> {
            System.out.println(k + "," + v);
        });

        List<UserEntity> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        System.out.println("------------------------------------");
        Set<UserEntity> set = list.stream().collect(Collectors.toSet());
        set.forEach(userEntity -> System.out.println(userEntity.toString()));

        System.out.println("-----------------------------------");
        //求和
        Optional<UserEntity> sum = list.stream().reduce(new BinaryOperator<UserEntity>() {
            @Override
            public UserEntity apply(UserEntity userEntity, UserEntity userEntity2) {
                UserEntity entity = new UserEntity("sum", userEntity.getAge() + userEntity2.getAge());
                return entity;

            }
        });

        int a = list.stream().reduce((u1, u2) -> {
            return new UserEntity("sum", u1.getAge() + u2.getAge());
        }).get().getAge();
        System.out.println(a);

        System.out.println(sum.get().getAge());
        System.out.println("------------------------------");
        //最大值
        int max = list.stream().min(new Comparator<UserEntity>() {
            @Override
            public int compare(UserEntity o1, UserEntity o2) {
                return o1.getAge() - o2.getAge();
            }
        }).get().getAge();

        System.out.println(list.stream().max(((o1, o2) -> o1.getAge() - o2.getAge())).get().getAge());

        System.out.println(max);
        System.out.println("-------------------------------------匹配");
//----------------------------------------------------------------------------------------
        //匹配
        boolean b = list.stream().anyMatch(new Predicate<UserEntity>() {
            @Override
            public boolean test(UserEntity userEntity) {
                return userEntity.getUserName().equals("com/zx");
            }
        });
        boolean b2 = list.stream().anyMatch(userEntity -> userEntity.getUserName().equals("com/zx"));

        System.out.println(b);
        System.out.println(b2);

//--------------------------------------------------------------------------------------
        //过滤
        System.out.println("---------------------------过滤");
        list.stream().filter(new Predicate<UserEntity>() {
            @Override
            public boolean test(UserEntity userEntity) {

                return userEntity.getUserName().equals("com/zx") && userEntity.getAge() > 25;
            }
        }).forEach(userEntity -> System.out.println(userEntity.toString()));

//  limit
        System.out.println("-----------------------------------------limit");
        list.stream().limit(3).forEach(new Consumer<UserEntity>() {
            @Override
            public void accept(UserEntity userEntity) {
                System.out.println(userEntity.toString());
            }
        });
//sort排序
        System.out.println("------------------------------------------");
        list.stream().sorted(new Comparator<UserEntity>() {
            @Override
            public int compare(UserEntity o1, UserEntity o2) {
                return o1.getAge() - o2.getAge();
            }
        }).forEach(userEntity -> System.out.println(userEntity.toString()));

    }

}
