/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // reverse order of words
        // O(N) time, O(N) space

        String[] words = s.trim().split("\\s+");

        for (int i = 0; i < words.length / 2; i++) {
            String tmp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = tmp;
        }

        return String.join(" ", words);
    }
}
// @lc code=end
