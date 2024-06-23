/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        /*
         * every element appears twice except for one
         * find the single one
         *
         * intuition:
         * - using xor property of A^A = 0 and A^A^B = B
         * - 0^A = A
         *
         * O(N) time, O(1) space
         */

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}
// @lc code=end
