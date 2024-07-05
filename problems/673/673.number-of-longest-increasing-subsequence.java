/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start

class Solution {
    public int findNumberOfLIS(int[] nums) {
        /*
         * return the number of longest increasing subsequences.
         *
         * [1,3,5,4,7] -> [1,3,4,7] or [1,3,5,7] -> 2
         * [2,2,2,2] -> [2] or [2] or ... -> 4
         *
         * intuition:
         * - bottom-up dp
         * - dp[i] -> longest increasing subsequence from i
         * - dp[i] -> (len, paths)
         *
         * O(N^2) time, O(N) space
         */

        record Pair(int len, int cnt) {
        }

        int n = nums.length;
        Pair[] dp = new Pair[n];
        dp[n - 1] = new Pair(1, 1);

        for (int i = n - 2; i >= 0; i--) {
            int cnt = 0;
            int maxLen = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    if (dp[j].len > maxLen) {
                        maxLen = dp[j].len;
                        cnt = dp[j].cnt;
                    } else if (dp[j].len == maxLen) {
                        cnt += dp[j].cnt;
                    }
                }
            }

            dp[i] = new Pair(maxLen + 1, cnt == 0 ? 1 : cnt);
        }

        int cnt = 0;
        int maxLen = 0;
        for (Pair p : dp) {
            if (p.len > maxLen) {
                maxLen = p.len;
                cnt = p.cnt;
            } else if (p.len == maxLen) {
                cnt += p.cnt;
            }
        }

        return cnt;
    }
}
// @lc code=end
