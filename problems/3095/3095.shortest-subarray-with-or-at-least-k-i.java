/*
 * @lc app=leetcode id=3095 lang=java
 *
 * [3095] Shortest Subarray With OR at Least K I
 */

// @lc code=start
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        // brute force search all subarrays
        // -1 if no special subarray exists
        
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr |= nums[j];

                if (curr >= k) {
                    res = Math.min(j - i + 1, res);
                    break;
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
// @lc code=end

