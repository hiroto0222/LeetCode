/*
 * @lc app=leetcode id=1964 lang=java
 *
 * [1964] Find the Longest Valid Obstacle Course at Each Position
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        /*
         * intuition:
         * - bottom-up dp
         * - res[i] -> max length of obstacle course for index i
         * - keep a stricitly increasing stack
         * - if obstacle > stack[-1] just append
         * - else, binary search first element stack[l] >= obstacle,
         * - replace with obstacle, and ans[i] = l + 1;
         *
         * O(NlogN) time, O(N) space.
         */

        int n = obstacles.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.add(obstacles[0]);
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            if (obstacles[i] >= stack.peek()) {
                stack.add(obstacles[i]);
                ans[i] = stack.size();
            } else {
                int idx = binarySearch(stack, obstacles[i]);
                stack.set(idx, obstacles[i]);
                ans[i] = idx + 1;
            }
        }

        return ans;
    }

    private int binarySearch(Stack<Integer> arr, int target) {
        int l = 0;
        int r = arr.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
// @lc code=end
