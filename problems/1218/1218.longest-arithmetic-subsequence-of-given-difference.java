/*
 * @lc app=leetcode id=1218 lang=java
 *
 * [1218] Longest Arithmetic Subsequence of Given Difference
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        /*
         * return longest subsequence in arr which is an arithmetic sequence such that
         * the difference between adjacent elements in the subsequence equals
         * difference.
         * if none exist, the longest sequence is any single element 1.
         *
         * intuition:
         * - dp using hashmap
         * - dp[i] -> max length of sequence up to i
         * - dp[i] = dp[i - diff] + 1 if (i - diff) exists
         *
         * O(N) time, O(N) space
         */

        HashMap<Integer, Integer> dp = new HashMap<>();
        int res = 1;

        for (int val : arr) {
            if (!dp.containsKey(val - difference)) {
                dp.put(val, 1);
                continue;
            }

            int currMax = Math.max(dp.getOrDefault(val, 1), dp.get(val - difference) + 1);
            dp.put(val, currMax);
            res = Math.max(currMax, res);
        }

        return res;
    }
}
// @lc code=end
