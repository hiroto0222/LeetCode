/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        // intuition:
        // keep track of count and update point k
        // k never over takes i
        // O(N) time, O(1) space

        int k = 0;
        int i = 0;

        while (i < chars.length) {
            // iterate till we find char not equal to prev or till end of chars
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }

            // now compress chars
            chars[k++] = chars[i];
            if (j - i > 1) {
                String cnt = j - i + "";
                for (char c : cnt.toCharArray()) {
                    chars[k++] = c;
                }
            }

            i = j;
        }

        return k;
    }
}
// @lc code=end
