/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        /*
         * return size of largest subset of strs such that at most
         * m "0"s and n "1"s
         *
         * intuition:
         * - recursive brute force dp with cache.
         * - dp(m,n)
         *
         * O(N^2) time, O(N) space.
         */

        Map<String, Integer> dp = new HashMap<>();
        return helper(strs, 0, m, n, 0, dp);
    }

    private int helper(String[] strs, int i, int m, int n, int size, Map<String, Integer> dp) {
        if (m < 0 || n < 0) {
            return size - 1;
        }

        if ((m == 0 && n == 0) || i >= strs.length) {
            return size;
        }

        String key = i + "," + m + "," + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int ones = countOnes(strs[i]);
        int zeros = strs[i].length() - ones;
        int res = Math.max(
                helper(strs, i + 1, m - zeros, n - ones, size + 1, dp),
                helper(strs, i + 1, m, n, size, dp));
        dp.put(key, res);

        return res;
    }

    private int countOnes(String str) {
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end
