/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
         * return min k such that all bananas can be eaten within h hours
         * k is the max bananas-per-hour
         * can only eat min(piles[i], k) bananas per hour
         * [3,6,7,11] h = 8
         * if k = 3 -> 1 + 2 + 3 + 4 = 10
         * if k = 4 -> 1 + 2 + 2 + 3 = 8
         *
         * intuition:
         * - maximum k required would be max(piles)
         * - binary search k from 1, max(piles)
         * - for every k, calculate total hours (O(N) -> 10**4)
         * - if hours > h then l = mid + 1
         * - if hours <= h then set curr k to mid and r = mid - 1
         *
         * O(NlogN) time, O(1) space
         */

        int maxPile = 0;
        for (int pile : piles) {
            if (pile > maxPile) {
                maxPile = pile;
            }
        }

        int l = 1;
        int r = maxPile;
        int res = Integer.MAX_VALUE;

        while (l <= r) {
            int k = l + (r - l) / 2;

            if (isWithinHours(piles, k, h)) {
                if (k < res) {
                    res = k;
                }
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }

    private boolean isWithinHours(int[] piles, int k, int h) {
        long sum = 0; // as pile[i] <= 10**9, which can cause int overflow
        for (int pile : piles) {
            sum += (pile + k - 1) / k;
        }
        return sum <= h;
    }
}
// @lc code=end
