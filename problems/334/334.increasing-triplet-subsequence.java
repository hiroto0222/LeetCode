/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // return true if there exists (i,j,k) such that
        // i < j < k and nums[i] < nums[j] < nums[k]
        //
        // intuition:
        // keep track of 2 values a, b
        // iterate nums where
        // 1. if nums[i] <= a, a = nums[i]
        // 2. if nums[i] > a and nums[i] <= b, b = nums[i]
        // 3. if nums[i] > a, b, then must have found triplet
        //
        // O(N) time, O(1) space

        int a = Integer.MAX_VALUE; // min value
        int b = Integer.MAX_VALUE; // 2nd min value

        for (int num : nums) {
            if (num > a && num > b) {
                return true;
            }

            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            }
        }

        return false;
    }
}
// @lc code=end
