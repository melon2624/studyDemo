package com.zx.desgin.Prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxin
 * @date 2022/9/14 16:45
 */
public class PrototypeTest {


    public static void main(String[] args) {
        ConcreteProtoTypeA concreteProtoTypeA = new ConcreteProtoTypeA();
        concreteProtoTypeA.setAge(18);
        concreteProtoTypeA.setName("zx");
        List<String> hobby = new ArrayList();
        concreteProtoTypeA.setHobbies(hobby);
        Client client = new Client(concreteProtoTypeA);
        ConcreteProtoTypeA prototypeClone = (ConcreteProtoTypeA) client.startClone(concreteProtoTypeA);
        System.out.println(concreteProtoTypeA);
        System.out.println(prototypeClone);

        System.out.println(concreteProtoTypeA.getHobbies());
        System.out.println(prototypeClone.getHobbies());
        System.out.println(prototypeClone.getHobbies()==concreteProtoTypeA.getHobbies());

    }

}
