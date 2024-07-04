/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        /*
         * given a string s, find the longest palindromic subsequence in s
         * s = "bbbab" -> "bbbb"
         *
         * intuition:
         * - longest subsequence approach
         * - compare against reversed s
         * - bottom-up dp
         *
         * O(N^2) time, O(N^2) space
         */

        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        String reversed = new StringBuilder(s).reverse().toString();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == reversed.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
// @lc code=end
