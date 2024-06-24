/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        /*
         * minimum operations to convert word1 to word2
         * 1. insert a character
         * 2. delete a character
         * 3. replace a character
         *
         * compare each letter in word1 and word2
         * 1. if word1[i] == word2[j] then i++, j++
         * 2. else consider the 3 operations
         * a) if insert, then we just increment j, but still need to deal with word1[i]
         * (i, j + 1)
         * b) if delete, then we just increment i, but still need to deal with word2[j]
         * (i + 1, j)
         * c) if replace, then we increment both
         * (i + 1, j + 1)
         *
         * dp[n][m] where dp[0][0] holds the min operations
         * dp[i][j] = min(dp[i][j + 1], dp[i + 1][j], dp[i + 1][j + 1])
         *
         * base cases are when either string has reached empty
         * the operations required are the length of the remaining string
         *
         * O(N*M) time, O(N*M) space
         */

        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // populate base cases
        for (int i = 0; i <= n; i++) {
            dp[i][m] = n - i;
        }
        for (int j = 0; j <= m; j++) {
            dp[n][j] = m - j;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // if letters are equal, no operations required
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
                // else, take the min of all 3 operations and add 1
                else {
                    int val = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.min(val, dp[i + 1][j + 1]) + 1;
                }
            }
        }

        return dp[0][0];
    }
}
// @lc code=end
