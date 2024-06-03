/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // no adjacent flower rule
        // count possible places to place flowers greedily
        // decrement n and check if n <= 0
        // O(N) time, O(1) space

        int m = flowerbed.length;

        for (int i = 0; i < m; i++) {
            int l = i == 0 ? 0 : flowerbed[i - 1];
            int r = i == m - 1 ? 0 : flowerbed[i + 1];

            if (l + flowerbed[i] + r == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
// @lc code=end
