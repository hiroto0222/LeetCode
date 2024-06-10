/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /*
         * find out state of asteroids after collisions
         *
         * intuition:
         * - keep stack of of all asteroids going
         * - for each asteroid going opposite from prev (right then left) update stack
         * 1. if value of asteroid[i] > value of stack[-1] -> stack[-1] = asteroid[i]
         * 2. if value of asteroid[i] < value of stack[-1] -> stack[-1] remains same
         * 3. if value of asteroid[i] == value of stack[-1] -> stack[-1] is removed
         *
         * O(N) time, O(N) space
         */

        Stack<Integer> stack = new Stack<>(); // all asteroids moving right

        for (int val : asteroids) {
            // if prev moving right and curr moving left, update stack
            boolean flag = false;
            while (!stack.isEmpty() && stack.peek() > 0 && val < 0) {
                if (stack.peek() > Math.abs(val)) {
                    flag = true;
                    break;
                }

                if (stack.peek() == Math.abs(val)) {
                    stack.pop();
                    flag = true;
                    break;
                }

                stack.pop();
            }

            if (!flag) {
                stack.push(val);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}
// @lc code=end
