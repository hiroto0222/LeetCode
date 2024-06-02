/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();

        // count freq of characters in string s
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // decrement freq of characters with string t
        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1);
        }

        // check if any character has non-zero freq
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
