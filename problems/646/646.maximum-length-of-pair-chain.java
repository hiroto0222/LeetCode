/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        /*
         * return the longest chain which can be formed.
         * pairs[i] = [left, right] where left < right
         * a chain of pairs is p1 = [a,b], p2 = [c,d] where b < c
         *
         * intuition:
         * - sort pairs by start
         * - dp[i] -> the longest chain up to pair i
         *
         * O(N^2) time, O(N) space
         */

        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // base case

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < n; i++) {
            int currMax = dp[i];
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1] && dp[j] + 1 > currMax) {
                    currMax = dp[j] + 1;
                }
            }

            dp[i] = currMax;
        }

        int res = 1;
        for (int val : dp) {
            if (val > res) {
                res = val;
            }
        }

        return res;
    }
}
// @lc code=end
