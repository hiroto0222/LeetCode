/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
         * return answer[i] is the number of days you have to wait after the ith day to
         * get a warmer temperature. if no future day, 0
         *
         * [73,74,75,71,69,72,76,73]
         * [1,1,4,2,1,1,0,0]
         *
         * intuition:
         * - keep track of the day (i) of temperatures that we still have not found the
         * next warmer temperature to.
         * - once such a day is found, update all the answer[i]
         * - keep a stack of the uncomputed days
         *
         * O(N) time, O(N) space
         */

        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // if stack is not empty, and the current temperature is higher than prev
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }

        return res;
    }
}
// @lc code=end
