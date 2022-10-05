package com.zx.leetcode.string;

/**
 * @author : xkdtm
 * @date : 2021-12-09 18:21
 **/


public class AddBinary二进制求和67 {

    public static String addBinary(String a, String b) {

        // StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        int lenthA = a.length() - 1;
        int lenthB = b.length() - 1;

        int carry = 0;


        while (lenthA >= 0 || lenthB >= 0) {

            int sum = 0;
            if (lenthA >= 0) {
                sum += Integer.parseInt(String.valueOf(a.charAt(lenthA)));
                lenthA--;
            }
            if (lenthB >= 0) {
                sum += Integer.parseInt(String.valueOf(b.charAt(lenthB)));
                lenthB--;
            }
            sum += carry;
            if (sum >= 2) {
                sum = sum % 2;
                carry = 1;
            } else {
                carry = 0;
            }
          //  stringBuilder.append(sum);
            s=sum+s;
        }

        if (carry == 1) {
            //stringBuilder.append(1);
            s=1+s;
        }

       // return stringBuilder.reverse().toString();
        return s;
    }

    public static void main(String[] args) {

        String anss = addBinary("1010", "1011");
        System.out.println(anss);
     /*   int a = 0;
        int b = 0;
        int ans = a & b;
        System.out.println(ans);

        int test = '1';
        System.out.println(test);*/
    }
}
