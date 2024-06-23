/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
         * return length of longest common subsequence of text1 and text2
         * if none return 0
         *
         * "abcde"
         * "abc"
         * if we find a common letter text1[i] == text2[j]
         * then 1 + next longest substring...
         *
         * intuition:
         * - 2D dp
         * - bottom-up DP
         * - if text1[i] == text2[j] -> dp[i][j] = 1 + dp[i + 1][j + 1]
         * - else dp[i][j] = max(dp[i + 1][j], dp[i][j + 1])
         *
         * O(N*M) time, O(N*M) space
         */

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // if equal, then add 1 to prev
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                // if not equal, find max of either right or down
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
// @lc code=end
