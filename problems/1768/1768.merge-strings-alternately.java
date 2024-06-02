/*
 * @lc app=leetcode id=1768 lang=java
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        StringBuilder ans = new StringBuilder();

        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                ans.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                ans.append(word2.charAt(i));
            }
            i++;
        }

        return ans.toString();
    }
}
// @lc code=end
