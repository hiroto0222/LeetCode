/*
 * @lc app=leetcode id=712 lang=java
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 */

// @lc code=start

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        /*
         * given 2 strings s1, s2, return the lowest ASCII sum of deleted characters to
         * make 2 strings equal.
         * a -> 97
         *
         * intuition:
         * - bottom-up dp
         * - taking approach from longest common subsequence
         *
         * if s1[i] = s2[j]:
         * dp[i][j] = dp[i+1][j+1]
         * else:
         * dp[i][j]
         * = min(s1[i] + dp[i+1][j], s2[j] + dp[i][j+1])
         * cases for remove s1[i], s2[j] or both
         *
         * O(N*M) time, O(N*M) space
         */

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // base cases
        // for empty s1
        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = dp[n][j + 1] + s2.charAt(j);
        }
        // for empty s2
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + s1.charAt(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i) + dp[i + 1][j], s2.charAt(j) + dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
// @lc code=end
