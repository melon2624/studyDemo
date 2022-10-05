package com.zx.entity;

import java.util.List;

/**
 * @author zhangxin
 * @date 2022/5/12 17:59
 */
public class HgBean {

    private String projectNo;
    private String idNo;
    private List<ProductList> productList;
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }
    public String getProjectNo() {
        return projectNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
    public String getIdNo() {
        return idNo;
    }

    public void setProductList(List<ProductList> productList) {
        this.productList = productList;
    }
    public List<ProductList> getProductList() {
        return productList;
    }

    public static class ProductList {

        private String productCode;
        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }
        public String getProductCode() {
            return productCode;
        }

    }


}
