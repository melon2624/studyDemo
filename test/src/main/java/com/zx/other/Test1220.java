package com.zx.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxin
 * @date 2022/12/20 20:50
 */
public class Test1220 {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);


      //  double streamResult=ints.stream().map()

    }

    private static double calc(List<Integer> ints) {

        //临时中间集合
        List<Point2D> point2DList = new ArrayList<>();

        for (Integer i : ints) {
            point2DList.add(new Point2D((double) i % 3, (double) i / 3));
        }
        //临时变量，存粹是为了获得最后结果所需要的中间变量
        double total = 0;
        int count = 0;

        for (Point2D point2D : point2DList) {
            //过滤
            if (point2D.getY() > 1) {
                //算距离
                double distance = point2D.distance(0, 0);
                total += distance;
                count++;
            }
        }
        //注意count可能为0的可能
        return count > 0 ? total / count : 0;
    }


}
