/*
 * @lc app=leetcode id=1561 lang=java
 *
 * [1561] Maximum Number of Coins You Can Get
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        // 3n piles of coins
        // - bob always picks min
        // - alice always picks max
        // - always pick 2nd max

        int n = piles.length;
        Arrays.sort(piles);
        int i = n - 2;
        int res = 0;
        while (i >= n / 3) {
            res += piles[i];
            i -= 2;
        }

        return res;        
    }
}
// @lc code=end

