package com.zx.desgin.factory.build.example2;

/**
 * @author zhangxin
 * @date 2022/8/29 16:14
 */
public class ConcreteBuilder implements Builder {
    /**
     * 生成器最终构建的产品对象
     */
    private Product resultProduct;

    public Product getResultProduct() {
        return resultProduct;
    }


    @Override
    public void buildPart() {
        //构建某个部件的功能处理
    }
}
