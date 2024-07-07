/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        /*
         * return the length of the longest arithmetic subsequence in nums.
         *
         * intuition:
         * - keep a hashmap of {diff -> length}
         * - for each nums[i] check against nums[:i]
         * - if nums[i] - nums[j] exists in dp[j], dp[i] add {nums[i] - nums[j] -> dp[j]
         * + 1}
         *
         * O(N^2) time, O(N^2) space
         */

        int n = nums.length;
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<Integer, Integer>());
        }

        int res = 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                Map<Integer, Integer> curr = dp.get(j);
                if (curr.containsKey(nums[i] - nums[j])) {
                    int len = curr.get(nums[i] - nums[j]) + 1;
                    dp.get(i).put(nums[i] - nums[j], len);
                    res = Math.max(res, len);
                } else {
                    dp.get(i).put(nums[i] - nums[j], 2);
                }
            }
        }

        return res;
    }
}
// @lc code=end
