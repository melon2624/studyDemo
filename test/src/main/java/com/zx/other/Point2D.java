package com.zx.other;

import lombok.Data;

/**
 * @author zhangxin
 * @date 2022/12/20 20:51
 */
@Data
public class Point2D {

    Double x;

    Double y;

    public Point2D() {
    }

    public Point2D(Double x, Double y) {
        this.x = x;
        this.y = y;
    }


    public double distance(double i, double y) {

        return 0;
    }
}
