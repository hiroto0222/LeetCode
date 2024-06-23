/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        // [1,1,1,1,1,1,1]
        // [1,2,3,4,5,6,7]
        // [1,3,6,10,15,21,28]
        // dp[row][col] = dp[row][col - 1] + dp[row - 1][col]
        // only need to keep track of previous row
        // bottom-up iterative dp
        // O(N*M) time, O(N) space

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        m--;
        while (m-- > 0) {
            for (int i = 0; i < n; i++) {
                dp[i] += i == 0 ? 0 : dp[i - 1];
            }
        }

        return dp[n - 1];
    }
}
// @lc code=end
