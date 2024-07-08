/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        /*
         * draw connecting lines from nums1[i] to nums2[j] where they equal.
         * no line can intersect, even at start/end points.
         * (each number can only have one connecting line)
         * return the max number of connecting lines.
         *
         * intuiition:
         * - same concept as longest common subsequence.
         *
         * O(N * M) time, O(N * M) space
         */

        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
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
