/*
 * @lc app=leetcode id=1431 lang=java
 *
 * [1431] Kids With the Greatest Number of Candies
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find max candies
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(candy, maxCandy);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int candy : candies) {
            ans.add(candy + extraCandies >= maxCandy);
        }

        return ans;
    }
}
// @lc code=end
