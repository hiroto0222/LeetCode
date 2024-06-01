/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 2 pointers
        // O(N) time, O(1) space

        if (nums.length == 1) {
            return 1;
        }

        int l = 1;
        int r = 1;

        while (r < nums.length) {
            if (nums[r] == nums[r - 1]) {
                r += 1;
                continue;
            }

            nums[l] = nums[r];
            r += 1;
            l += 1;
        }

        return l;
    }
}
// @lc code=end
