/*
 * @lc app=leetcode id=1137 lang=java
 *
 * [1137] N-th Tribonacci Number
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        /*
         * Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0
         *
         * intuition:
         * - keep track of previous calculations
         *
         * O(N) time, O(1) space
         */

        if (n < 2) {
            return n;
        }

        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }

        return c;
    }
}
// @lc code=end
