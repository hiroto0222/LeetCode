/*
 * @lc app=leetcode id=2390 lang=java
 *
 * [2390] Removing Stars From a String
 */

// @lc code=start
class Solution {
    public String removeStars(String s) {
        /*
         * return string after all stars have been removed
         *
         * intuition:
         * - 2 pointers
         * - i keeps track of valid char insert position
         * - j iterates through characters
         * - if s[j] = "*" -> decrement i to replace prev char with next valid char
         * - else -> s[i] = s[j] and increment i
         * - s[0:i] contain valid chars
         *
         * O(N) time, O(N) space
         */

        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == '*') {
                i--;
            } else {
                chars[i] = chars[j];
                i++;
            }
        }

        return new String(chars, 0, i);
    }
}
// @lc code=end
