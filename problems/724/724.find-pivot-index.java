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
         * O(N) time, O(N) space
         */

        int[] prefix = new int[nums.length];

        // populate with prefix
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev += nums[i];
            prefix[i] = prev;
        }

        // calculate suffix and compare with prefix
        int ans = -1;
        int suffix = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int pref = i == 0 ? 0 : prefix[i - 1];

            if (suffix == pref) {
                ans = i;
            }

            suffix += nums[i];
        }

        return ans;
    }
}
// @lc code=end
