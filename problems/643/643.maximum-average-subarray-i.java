/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        /*
         * find max average subarray length k in nums
         * k <= n
         *
         * intuition:
         * - sliding window
         * - keep track of max sum subarray
         *
         * O(N) time, O(1) space
         */

        double currMax = Integer.MIN_VALUE;
        int l = 0;
        double currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (i >= k - 1) {
                if (currSum / k > currMax)
                    currMax = currSum / k;

                currSum -= nums[l];
                l++;
            }
        }

        return currMax;
    }
}
// @lc code=end
