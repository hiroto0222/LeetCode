/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        /*
         * return the number of distinct subsequences of s which equals t.
         *
         * s = "rabbbit"
         * t = "rabbit"
         * -> 3
         *
         * intuition:
         * - dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j] if s[i] == t[j] (use or skip)
         * - else dp[i + 1][j] (skip)
         * - using recursion and memoization
         *
         * O(N * M) time, O(N * M) space
         */

        Integer[][] dp = new Integer[s.length()][t.length()];

        return dfs(0, 0, s, t, dp);
    }

    private int dfs(int i, int j, String s, String t, Integer[][] dp) {
        // if t = "", then only 1 subsequence of s exists
        if (j == t.length()) {
            return 1;
        }
        // if s = "" and t != "" then no subsequence exists
        if (i == s.length()) {
            return 0;
        }
        // if already computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        // if equal, check cases for use letter and skip letter
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(i + 1, j + 1, s, t, dp) + dfs(i + 1, j, s, t, dp);
        }
        // if not equal, check case for skip
        else {
            dp[i][j] = dfs(i + 1, j, s, t, dp);
        }

        return dp[i][j];
    }
}
// @lc code=end
