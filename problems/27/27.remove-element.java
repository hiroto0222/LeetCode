/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        // 2 pointers
        // l -> keep track of value = val from left
        // r -> keep track of value != val to replace from right
        // O(N) time, O(1) space

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            // decrement r till we find nums[r] != val
            if (nums[r] == val) {
                r -= 1;
                continue;
            }

            if (nums[l] == val) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                r -= 1;
            }

            l += 1;
        }

        return l;
    }
}
// @lc code=end
