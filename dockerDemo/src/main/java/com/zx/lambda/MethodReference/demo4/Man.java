package com.zx.lambda.MethodReference.demo4;

/**
 * @author zhangxin
 * @date 2022/12/22 9:57
 */
public class Man extends Human {

    @Override
    public void sayHello() {
        //super.sayHello();
        System.out.println("Hello 我是Man!");
    }


    public  void method(Greetable greetable){
        greetable.greet();
    }

    public  void  show(){

     /*   method(
                ()->{

                    Human human=new Human();
                    human.sayHello();
                }
        );*/

        method(()->{
            super.sayHello();
        });

    }


}
