package com.zx.lambda.MethodReference.demo1;

/**
 * 通过类名引用静态成员方法
 * 类已经存在，静态成员方法也已经存在
 * 就可以通过类名直接引用静态成员方法
 *
 * @author zhangxin
 * @date 2022/12/21 18:18
 */
public class StaticMethodReference {

    // 定义一个方法,方法的参数传递要计算绝对值的整数,和函数式接口Calcable
    public static int method(int number, Calcable c) {

        return c.calsAbs(number);
    }

    public static void main(String[] args) {

        int number = method(-10, n -> {
            return Math.abs(n);
        });

        System.out.println(number);

          /*
            使用方法引用优化Lambda表达式
            Math类是存在的
            abs计算绝对值的静态方法也是已经存在的
            所以我们可以直接通过类名引用静态方法
         */
        int number2 = method(-20, Math::abs);
        System.out.println(number2);
    }


}
