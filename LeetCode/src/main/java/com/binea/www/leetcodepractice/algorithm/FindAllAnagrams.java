package com.binea.www.leetcodepractice.algorithm;
// Created by binea on 3/20/17.

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams_22ms(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256];

        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) count--;

            if (count == 0) list.add(left);

            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }

        return list;
    }

    public List<Integer> findAnagrams_18ms(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[128];
        for (char c : p.toCharArray()) map[c]++;
        int start = 0, end = 0, count = p.length();
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if (end - start == p.length()) res.add(start);
                if (map[s.charAt(start++)]++ >= 0) count++;
            }
        }
        return res;
    }
}
