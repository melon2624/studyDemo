package com.zx.util;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author zhangxin
 * @date 2022/4/25 18:06
 */
public class Base64Util {


    private static final char _$2[];

    private static final int _$1[];

    static {
        _$2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_.".toCharArray();
        _$1 = new int[256];
        Arrays.fill(_$1, -1);
        int i = 0;
        for (int j = _$2.length; i < j; i++)
            _$1[_$2[i]] = i;

        _$1[61] = 0;
    }

    public static String encode(String str) {
        // base64字符串
        String base64Str = "";
        try {
            // String-->byte[]
            byte[] data = str.getBytes("utf-8");
            // 编码
            base64Str = Base64.getEncoder().encodeToString(data);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return base64Str;
    }

    public static String decode(String base64Str) {
        // 解码后的字符串
        String str = "";
        // 解码
        byte[] base64Data = Base64.getDecoder().decode(base64Str);
        try {
            // byte[]-->String
            str = new String(base64Data, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static final String encode(byte[] s) {
        String result = null;
        try {
            result = new String(encodeToChar(s, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static final char[] encodeToChar(byte abyte0[], boolean flag) {
        int i = abyte0 == null ? 0 : abyte0.length;
        if (i == 0)
            return new char[0];
        int j = (i / 3) * 3;
        int k = (i - 1) / 3 + 1 << 2;
        int l = k + (flag ? (k - 1) / 76 << 1 : 0);
        char ac[] = new char[l];
        int i1 = 0;
        int j1 = 0;
        int l1 = 0;
        do {
            if (i1 >= j)
                break;
            int i2 = (abyte0[i1++] & 0xff) << 16 | (abyte0[i1++] & 0xff) << 8 | abyte0[i1++] & 0xff;
            ac[j1++] = _$2[i2 >>> 18 & 0x3f];
            ac[j1++] = _$2[i2 >>> 12 & 0x3f];
            ac[j1++] = _$2[i2 >>> 6 & 0x3f];
            ac[j1++] = _$2[i2 & 0x3f];
            if (flag && ++l1 == 19 && j1 < l - 2) {
                ac[j1++] = '\r';
                ac[j1++] = '\n';
                l1 = 0;
            }
        } while (true);
        i1 = i - j;
        if (i1 > 0) {
            int k1 = (abyte0[j] & 0xff) << 10 | (i1 != 2 ? 0 : (abyte0[i - 1] & 0xff) << 2);
            ac[l - 4] = _$2[k1 >> 12];
            ac[l - 3] = _$2[k1 >>> 6 & 0x3f];
            ac[l - 2] = i1 != 2 ? '.' : _$2[k1 & 0x3f];
            ac[l - 1] = '.';
        }
        return ac;
    }

    public static final byte[] decodeFast(String s) {
        int i = s.length();
        if (i == 0)
            return new byte[0];
        int j = 0;
        int k;
        for (k = i - 1; j < k && _$1[s.charAt(j) & 0xff] < 0; j++)
            ;
        for (; k > 0 && _$1[s.charAt(k) & 0xff] < 0; k--)
            ;
        byte byte0 = s.charAt(k) != '.' ? 0 : ((byte) (s.charAt(k - 1) != '.' ? 1 : 2));
        int l = (k - j) + 1;
        int i1 = i <= 76 ? 0 : (s.charAt(76) != '\r' ? 0 : l / 78) << 1;
        int j1 = ((l - i1) * 6 >> 3) - byte0;
        byte abyte0[] = new byte[j1];
        int k1 = 0;
        int l1 = 0;
        int j2 = (j1 / 3) * 3;
        do {
            if (k1 >= j2)
                break;
            int i3 = _$1[s.charAt(j++)] << 18 | _$1[s.charAt(j++)] << 12 | _$1[s.charAt(j++)] << 6 | _$1[s.charAt(j++)];
            abyte0[k1++] = (byte) (i3 >> 16);
            abyte0[k1++] = (byte) (i3 >> 8);
            abyte0[k1++] = (byte) i3;
            if (i1 > 0 && ++l1 == 19) {
                j += 2;
                l1 = 0;
            }
        } while (true);
        if (k1 < j1) {
            int i2 = 0;
            for (int k2 = 0; j <= k - byte0; k2++)
                i2 |= _$1[s.charAt(j++)] << 18 - k2 * 6;

            for (int l2 = 16; k1 < j1; l2 -= 8)
                abyte0[k1++] = (byte) (i2 >> l2);

        }
        return abyte0;
    }


}
