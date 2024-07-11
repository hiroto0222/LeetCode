/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        /*
         * given digits s, return number of ways to decode to letters.
         * s = "12" -> "AB", "L"
         *
         * intuition:
         * - take s[i] or take s[i:i + 1] iff s[i] != "0".
         * - recursive brute force with cache
         * - dp[i] = the number of ways to decode starting from s[i]
         *
         * O() time, O(N) space.
         */

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, 0, dp);
    }

    private int helper(String s, int i, int twoDigits, int[] dp) {
        // if twoDigits exceeds 26, return 0.
        if (twoDigits > 26) {
            return 0;
        }
        // if end of s reached, return 1.
        if (i == s.length()) {
            return 1;
        }
        // if already computed, return value.
        if (dp[i] != -1) {
            return dp[i];
        }

        int res = 0;
        int c = Character.getNumericValue(s.charAt(i));
        if (c != 0) {
            // take s[i]
            res += helper(s, i + 1, 0, dp);
            if (i + 1 < s.length()) {
                // take s[i:i+1]
                res += helper(s, i + 2, c * 10 + Character.getNumericValue(s.charAt(i + 1)), dp);
            }
        }

        dp[i] = res;
        return dp[i];
    }
}
// @lc code=end
