/*
 * @lc app=leetcode id=2300 lang=java
 *
 * [2300] Successful Pairs of Spells and Potions
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        /*
         * a pair spell[i] and potion[j] is considered successful if
         * spell[i] * potion[j] >= success.
         * return array pairs of length n, where pairs[i] is number of potions
         * that will form a successful pair with the ith spell.
         *
         * [3,1,2] 16
         * [8,5,8] -> [5,8,8]
         *
         * intuition:
         * - sort potions in ascending order
         * - binary search min j such that potions[j:] are successful
         *
         * O(NlogN) time, O(N) space
         */

        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int target = (int) Math.ceil((double) success / spell);

            int l = 0;
            int r = m - 1;
            int res = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (potions[mid] >= target) {
                    res = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            ans[i] = res == -1 ? 0 : m - res;
        }

        return ans;
    }
}
// @lc code=end
