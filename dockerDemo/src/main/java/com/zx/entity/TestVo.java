package com.zx.entity;

import lombok.Data;

@Data
public class TestVo {

    String A;

    String B;

    public String getA() {
        return A;
    }

    public void setA(String A) {
        A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        B = B;
    }
}
