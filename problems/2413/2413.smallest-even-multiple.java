/*
 * @lc app=leetcode id=2413 lang=java
 *
 * [2413] Smallest Even Multiple
 */

// @lc code=start
class Solution {
    public int smallestEvenMultiple(int n) {
        /*
         * given n, return smallest positive interger where multiple of both 2 and n.
         */

        return (n % 2 == 0) ? n : 2 * n;
    }
}
// @lc code=end
