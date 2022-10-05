package com.zx.desgin.Prototype;

/**
 * @author zhangxin
 * @date 2022/9/14 16:43
 */
public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype concretePrototype) {
        return (Prototype) concretePrototype.clone();
    }

}
