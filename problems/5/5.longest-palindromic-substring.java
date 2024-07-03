/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        /*
         * given string s, return longest palindromic string.
         * s = "babad" -> "bab" or "aba"
         *
         * intuition:
         * - boolean dp table for dp(start,end) = whether s[start:end] is palindrome
         * - if s[start] = s[end] and dp[start+1][end-1] = true,
         * - then s[start:end] is a palindrome
         *
         * O(N^2) time, O(N^2) space
         */

        int n = s.length();
        if (n <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        int currMax = 1;
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                // if boundary characters equal, and inside is palindrome, or length is <= 2
                if (s.charAt(j) == s.charAt(i) && ((i - j <= 2) || dp[j + 1][i - 1])) {
                    dp[j][i] = true;

                    if (i - j + 1 > currMax) {
                        currMax = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}

// @lc code=end
