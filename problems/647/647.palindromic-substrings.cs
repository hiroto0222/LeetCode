/*
 * @lc app=leetcode id=647 lang=csharp
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
public class Solution {
    public int CountSubstrings(string s) {
        // palindrome only if i+1,...,j-1 is a palindrome and s[i] == s[j]

        int n = s.Length;
        int res = 0;
        bool[,] dp = new bool[n, n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i, j] = s[i] == s[j] && (j - i + 1 < 3 || dp[i + 1, j - 1]);
                if (dp[i, j]) res++;
            }
        }

        return res;
    }
}
// @lc code=end

