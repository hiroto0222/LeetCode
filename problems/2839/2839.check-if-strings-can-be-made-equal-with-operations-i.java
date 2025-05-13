/*
 * @lc app=leetcode id=2839 lang=java
 *
 * [2839] Check if Strings Can be Made Equal With Operations I
 */

// @lc code=start
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // choose i, j such that j - i = 2, then swap chars
        // true if s1 == s2, false otherwise

        boolean res = true;
        for (int i = 0; i < 2; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                res &= (s1.charAt(i + 2) == s2.charAt(i + 2));
            } else {
                res &= ((s1.charAt(i) == s2.charAt(i + 2)) && (s1.charAt(i + 2) == s2.charAt(i)));
            }
        }

        return res;
    }
}
// @lc code=end

