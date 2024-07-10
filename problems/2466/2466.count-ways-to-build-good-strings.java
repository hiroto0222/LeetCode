/*
 * @lc app=leetcode id=2466 lang=java
 *
 * [2466] Count Ways To Build Good Strings
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        /*
         * return number of different good strings of length between low and high.
         * stores lengths as modulo of 10^9 + 7
         *
         * intuition:
         * - recursive dp with cache
         * - dp[i] -> number of different good strings up to length i.
         *
         * O(N * M) time, O(N) space.
         */

        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);

        int res = 0;
        for (int len = low; len <= high; len++) {
            res = (res + helper(dp, len, zero, one)) % 1000000007;
        }

        return res;
    }

    private int helper(int[] dp, int lenRequired, int zero, int one) {
        // if exact, count as good string
        if (lenRequired == 0) {
            return 1;
        }
        // if exceeds length required, dont count as good string
        if (lenRequired < 0) {
            return 0;
        }
        // if already computed, return computed value
        if (dp[lenRequired] != -1) {
            return dp[lenRequired];
        }
        // else try adding either ones or zeros
        dp[lenRequired] = (helper(dp, lenRequired - zero, zero, one) + helper(dp, lenRequired - one, zero, one))
                % 1000000007;
        return dp[lenRequired];
    }
}
// @lc code=end
