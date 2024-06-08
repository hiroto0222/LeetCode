/*
 * @lc app=leetcode id=724 lang=java
 *
 * [724] Find Pivot Index
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        /*
         * return left most pivot index
         * pivot -> nums[0:i] == nums[i+1:n] not i inclusive
         * if DNE, then return -1
         * [2,1,-1] pivot = 0 -> left = 0, right = 1 + (-1) = 0
         *
         * intuition:
         * - consider prefix, suffix sum
         * [1,7,3,6,5,6]
         * [1,8,11,17,22,28]
         * [28,27,20,17,11,6]
         *
         * O(N) time, O(1) space
         */

        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            // if leftSum == totalSum - leftSum - nums[i] -> then left most pivot index
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
// @lc code=end
