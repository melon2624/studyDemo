package com.zx.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 重复的DNA序列187
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * @author : xkdtm
 * @date : 2022-01-13 10:28
 **/
public class FindRepeatedDnaSequences重复的DNA序列187 {

    public static List<String> findRepeatedDnaSequences(String s) {

        Map<String, Object> map = new HashMap();

        HashSet<String> stringHashSet = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {

            String sub = s.substring(i - 10, i);

            if (map.get(sub) == null) {
                map.put(sub, "");
            } else {
                stringHashSet.add(sub);
            }
        }

        return stringHashSet.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {

        String a = "AAAAAAAAAAA";

        String b = a.substring(0, 5);

        findRepeatedDnaSequences(a);
    }


}
