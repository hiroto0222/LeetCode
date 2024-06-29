/*
 * @lc app=leetcode id=2222 lang=java
 *
 * [2222] Number of Ways to Select Buildings
 */

// @lc code=start
class Solution {
    public long numberOfWays(String s) {
        /*
         * s[i] = '0' office
         * s[i] = '1' restaurant
         * select 3 buildings at random, with no 2 consecutive buildings of the same
         * type.
         * return the number of valid ways to select 3 buildings.
         *
         * s = "001101"
         * cannot choose 1,3,5 -> "011"
         *
         * intuition:
         * - nC3 total combinations
         * - the only possible patterns are "010" or "101"
         * - if prev is "0" then must pick "1"
         * - if prev is "1" then must pick "0"
         *
         */
    }
}
// @lc code=end
