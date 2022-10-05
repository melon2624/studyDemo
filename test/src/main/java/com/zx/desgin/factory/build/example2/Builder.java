package com.zx.desgin.factory.build.example2;

/**
 * 生成器接口,定义创建一个产品对象所需的各个部件的操作
 * @author zhangxin
 * @date 2022/8/29 16:13
 */
public interface Builder {
    /**
     * 示意方法，构建某个部件
     */
    public void buildPart();

}
