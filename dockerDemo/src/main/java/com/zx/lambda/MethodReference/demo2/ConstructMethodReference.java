package com.zx.lambda.MethodReference.demo2;

/**
 * @author zhangxin
 * @date 2022/12/21 18:29
 */
public class ConstructMethodReference {

    public static void main(String[] args) {

        //调用printName方法,方法的参数PersonBuilder接口是一个函数式接口,可以传递Lambda
        printName("zhangxin", p -> new Person(p));

         /*
            使用方法引用优化Lambda表达式
            构造方法new Person(String name) 已知
            创建对象已知 new
            就可以使用Person引用new创建对象
         */
        printName("zhangxin", Person::new);//使用Person类的带参构造方法,通过传递的姓名创建对象

    }

    //定义一个方法,参数传递姓名和PersonBuilder接口,方法中通过姓名创建Person对象
    public static void printName(String name, PersonBuilder personBuilder) {

        Person person = personBuilder.builderPerson(name);
        System.out.println(person.getName());

    }

}
