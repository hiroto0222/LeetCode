/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        /**
         * Check if s is substring of t
         *
         * intuition:
         * 1. iterate chars in t till all checks against t is met
         * 2. keep hashmap of chars in t
         *
         * O(N) time, O(1) space
         */

        // if s is empty, s is always a substring of t
        if (s.isEmpty()) {
            return true;
        }

        // if above not met and t is empty, then s can never be a subtring of t
        if (t.isEmpty()) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
// @lc code=end
