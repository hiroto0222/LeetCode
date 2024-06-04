/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // ans[i] is product of all elements except nums[i]
        // [1,2,3,4]
        // prefix -> [1,2,6,24]
        // suffix -> [24,24,12,4]
        // keep track of prefix product in ans arr
        // keep track of suffix product in var
        // O(N) time, O(1) space

        int n = nums.length;
        int[] ans = new int[n];

        // populate ans with prefix product
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = prefix * nums[i];
            prefix *= nums[i];
        }

        // calculate ans using prefix and suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            int currPrefix = i == 0 ? 1 : ans[i - 1];
            ans[i] = currPrefix * suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}
// @lc code=end
