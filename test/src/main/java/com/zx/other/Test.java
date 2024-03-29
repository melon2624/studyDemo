package com.zx.other;

import com.zx.entity.Student;
import com.zx.other.date.DateUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * @author : zhangxin
 * @date : 2021-11-03 17:37
 **/
public class Test {

    public static void main1(String[] args) {

        Student s1 = new Student(1, "com/zx", 24);
        Student s2 = new Student(2, "zm", 19);
        Student s3 = new Student(3, "gm", 25);
        Student s4 = new Student(4, "gj", 30);
        Student s5 = new Student(5, "xx", 10);

        List<Student> studentList = new ArrayList<>();
        studentList.add(s2);
        studentList.add(s1);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        Collections.sort(studentList, (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }


/*    考虑用动态规划的思想来解决这个问题。

    很容易可以发现，对于我们当前考虑的这个数，要么是作为山峰（即nums[i] > nums[i-1]），要么是作为山谷（即nums[i] < nums[i - 1]）。

    设dp状态dp[i][0]，表示考虑前i个数，第i个数作为山峰的摆动子序列的最长长度
    设dp状态dp[i][1]，表示考虑前i个数，第i个数作为山谷的摆动子序列的最长长度
    则转移方程为：

    dp[i][0] = max(dp[i][0], dp[j][1] + 1)，其中0 < j < i且nums[j] < nums[i]，表示将nums[i]接到前面某个山谷后面，作为山峰。
    dp[i][1] = max(dp[i][1], dp[j][0] + 1)，其中0 < j < i且nums[j] > nums[i]，表示将nums[i]接到前面某个山峰后面，作为山谷。
    初始状态：

    由于一个数可以接到前面的某个数后面，也可以以自身为子序列的起点，所以初始状态为：dp[0][0] = dp[0][1] = 1。*/

/*
   // DP
class Solution {
    public int wiggleMaxLength(int[] nums) {
        // 0 i 作为波峰的最大长度
        // 1 i 作为波谷的最大长度
        int dp[][] = new int[nums.length][2];

        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++){
            //i 自己可以成为波峰或者波谷
            dp[i][0] = dp[i][1] = 1;

            for (int j = 0; j < i; j++){
                if (nums[j] > nums[i]){
                    // i 是波谷
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                if (nums[j] < nums[i]){
                    // i 是波峰
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
*/



/*    public static void main(String[] args) {

        String a = "1";
        int b = Integer.parseInt(String.valueOf(a.charAt(0)));
        System.out.println(b);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(2);
        stringBuilder.append(1);
        System.out.println(stringBuilder.toString());


    }*/

    public static void test2(String[] args) throws ParseException {
        String a = "测试组/hkl001/zhanxgin54/zxxx/zx";

        String[] split = a.split("/");

        List<String> list = new ArrayList<>();

        Collections.addAll(list, split);

        BigDecimal time = new BigDecimal(0);
        time = time.add(new BigDecimal("0"));

        System.out.println(time);
        List<String> aaa = null;
        for (String b : aaa) {
            System.out.println(b);
        }

    }

    public static void main(String[] args) {

        Student student = new Student();

        Optional<Student> stu = Optional.of(student);
        System.out.println(stu.isPresent());


      /*  byte g = 'b';
        System.out.println(g);
        char h = (char) g;
        int j = 'a';
        char i = 85;
        System.out.println(j);
        System.out.println(h);
        System.out.println(i);*/
    }

    public static void set() {
        TreeSet<Integer> hs = new TreeSet<>();
    }

    public static void test() {
         /*  Student s1 = new Student(1, "zx", 24);
        Student s2 = new Student(2, "zm", 19);
        Student s3 = new Student(3, "gm", 25);
        Queue<Student> queue=new LinkedList();
        queue.add(s1);
        Student a=queue.poll();
        Student b=queue.peek();*/
       /* Queue<Student> queue = new LinkedList<>();
        queue.add(null);
        queue.add(null);
        System.out.println(queue.size());*/
        System.out.println((2 << 3) - 1);

        String a = "CYH5_20211115124345044240";
        String b = a.substring(5, 11);
        System.out.println(b);
        System.out.println(Integer.MIN_VALUE);

        String time1 = "20211202";
        String time2 = "20211201";

        int result = time1.compareTo(time2);

        System.out.println(result);

        String aaa = DateUtils.getCurrentTime("yyyyMMddHHmm").substring(10, 12);
        String uiu = DateUtils.getCurrentTime("yyyyMMddHHmm");
        String abbbb = "03";
        int sss = Integer.parseInt(abbbb);
    }


}
