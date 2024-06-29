/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        /*
         * find i,j,k such that i < j < k and nums[i] < nums[k] < nums[j]
         *
         * intuition:
         * - we need to find a nums[k], that is between nums[i] and nums[j]
         * - can keep a stack of the previous encountered min and max
         *
         * O(N) time, O(N) space
         */

        Stack<int[]> stack = new Stack<>(); // [currmin, currmax]
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // if curr value is greater than top of stack max, then pop
            while (!stack.isEmpty() && curr >= stack.peek()[1]) {
                stack.pop();
            }
            // if curr value is now less than max and greater than curr min, return
            if (!stack.isEmpty() && curr > stack.peek()[0]) {
                return true;
            }

            stack.push(new int[] { currMin, curr });
            currMin = Math.min(currMin, curr);
        }

        return false;
    }
}
// @lc code=end
