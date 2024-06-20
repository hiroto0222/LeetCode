/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<Character, String> map = new HashMap<>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        /*
         * return all possible letter combinations for digits
         * 23 -> ["ad","ae","af","bd","be","bf","cd","ce","cf"]
         *
         * intuition:
         * - create hashmap of digit -> letters
         * - recursive
         *
         * O(3^N + 4^N) time, but upper bound is "9999" -> 4^4 ~ 256 times
         * O(N) space, recursive stack
         */

        List<String> res = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return res;
        }

        dfs(digits, 0, new StringBuilder(), res, this.map);

        return res;
    }

    private void dfs(String digits, int i, StringBuilder sb, List<String> res, Map<Character, String> map) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(i));
        for (char c : letters.toCharArray()) {
            sb.append(c);
            dfs(digits, i + 1, sb, res, map);
            // backtrack by deleting last added character
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end
