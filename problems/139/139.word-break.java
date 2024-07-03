/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
         * return true if s can be segmented into a sequence of one or more dictionary
         * words.
         *
         * "leetcode" ["leet", "code"] -> true
         *
         * intuition:
         * - bottom-up dp
         * - dp[i] -> whether s[i:] can be made from dictionary words
         *
         * O(N*M) time, O(N) space
         */

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true; // end of string would be true

        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                // check if word is equal to substring
                if (i + word.length() <= n && word.equals(s.substring(i, i + word.length()))) {
                    dp[i] = dp[i + word.length()];
                }
                // if equal we can just break and check the next substring
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
// @lc code=end
