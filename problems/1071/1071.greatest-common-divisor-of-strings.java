/*
 * @lc app=leetcode id=1071 lang=java
 *
 * [1071] Greatest Common Divisor of Strings
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // if: str1 + str2 = str2 + str1, then such x exists
        // then x is the substring(0, gcd(n, m)) of either str1, str2
        // else: x does not exist

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int x = gcd(str1.length(), str2.length());
        return str1.substring(0, x);
    }

    // euclidean algorithm for gcd
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
// @lc code=end
