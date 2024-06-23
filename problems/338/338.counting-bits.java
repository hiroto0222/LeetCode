/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        /*
         * return ans[i] is number of 1's in binary representation of i
         * 0 <= n <= 10**5
         *
         * intuition:
         * - count 1 bits and shift to right
         *
         * O(NlogN) time, O(N) space
         */

        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int cnt = 0;
            int curr = i;
            while (curr != 0) {
                cnt += curr & 1;
                curr >>= 1;
            }
            ans[i] = cnt;
        }

        return ans;
    }
}
// @lc code=end
