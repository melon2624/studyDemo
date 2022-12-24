package com.zx.lambda.MethodReference.demo3;

/**
 * @author zhangxin
 * @date 2022/12/22 8:54
 */
public class ObjectMethodReference {

    public static void main(String[] args) {
        //调用printString方法,方法的参数Printable是一个函数式接口,所以可以传递Lambda表达式
        printString(s -> {
            //创建MethodRerObject对象
            MethodRerObject methodRerObject=new MethodRerObject();
            //调用MethodRerObject对象中的成员方法printUpperCaseString,把字符串按照大写输出
            methodRerObject.printUpperCaseString(s);
        } );

           /*
            使用方法引用优化Lambda
            对象是已经存在的MethodRerObject
            成员方法也是已经存在的printUpperCaseString
            所以我们可以使用对象名引用成员方法
         */
        //创建MethodRerObject对象
        MethodRerObject methodRerObject=new MethodRerObject();
        printString(methodRerObject::printUpperCaseString);

    }


    public  static  void  printString(Printable printable){
        printable.print("hello");
    }


}
