/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        /**
         * move all 0s to end of array, keeping relative order, and in place
         * intuition:
         * - 2 pointer swap
         * - l keeps track of zero to swap with nums[r]
         * - r iterates till non-zero is found, then swaps with nums[l]
         *
         * [1,2,3,4,5]
         *
         *
         * O(N) time, O(1) space
         */

        int l = 0;
        int r = 0;

        while (r < nums.length) {
            // iterate till r is non-zero
            if (nums[r] == 0) {
                r++;
                continue;
            }

            // swap
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r++;
        }
    }
}
// @lc code=end
