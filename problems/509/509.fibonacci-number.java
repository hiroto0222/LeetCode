/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        /*
         * F(0) = 0, F(1) = 1
         * F(n) = F(n - 1) + F(n - 2) for n > 1
         *
         * O(N) time, O(1) space
         */

        if (n == 0) {
            return 0;
        }

        int prev = 0;
        int curr = 1;

        for (int i = 1; i < n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }

        return curr;
    }
}
// @lc code=end
