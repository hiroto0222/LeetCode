/*
 * @lc app=leetcode id=1679 lang=java
 *
 * [1679] Max Number of K-Sum Pairs
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        /**
         * max number of operations, where 1 operation is to pick 2 values
         * from nums that equal k, then remove both
         *
         * intuition:
         * - sort, then 2 pointer
         * 1. initially sort nums
         * 2. 2 pointers l = 0, r = n - 1
         * 3. if nums[l] + nums[r] > k -> decrement r
         * else if < k -> increment l
         * else decrement r, increment l
         *
         * O(NlogN) time, O(1) space
         */

        // sort nums
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;
        int operations = 0;

        while (l < r) {
            if (nums[l] + nums[r] > k) {
                r--;
            } else if (nums[l] + nums[r] < k) {
                l++;
            } else {
                operations++;
                l++;
                r--;
            }
        }

        return operations;
    }
}
// @lc code=end
