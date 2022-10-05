package com.zx.desgin.factory.build.example1;

/**
 * 描述输出数据的对象
 * @author zhangxin
 * @date 2022/8/22 20:49
 */
public class ExportDataModel {

    /**
     * 产品编号
     */
    public String productId;

    /**
     * 销售价格
     */
    private double price;

    /**
     *销售数量
     */
    private double amount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
