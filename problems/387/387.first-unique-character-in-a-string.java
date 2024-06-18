/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start

class Solution {
    public int firstUniqChar(String s) {
        /*
         * return index of first non-repeating character
         * s = "loveleetcode"
         * -> 2
         *
         * intuition:
         * - array to keep track of cnt of 26 english lower case letters
         * - after counting, iterate again and return the first index
         * where cnt == 1
         *
         * O(N) time, O(N) space
         */

        int[] seen = new int[26];

        // increment cnts of each seen letter
        for (int i = 0; i < s.length(); i++) {
            seen[s.charAt(i) - 'a']++;
        }
        // obtain first non-repeating character and return its index
        for (int i = 0; i < s.length(); i++) {
            if (seen[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        // does not exist
        return -1;
    }
}
// @lc code=end
