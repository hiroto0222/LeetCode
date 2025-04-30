/*
 * @lc app=leetcode id=2391 lang=java
 *
 * [2391] Minimum Amount of Time to Collect Garbage
 */

// @lc code=start
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        // picking up 1 unit of garbage takes 1 min
        // garbage truck conditions:
        // - only 1 truck may be used at any given moment
        // - must visit each house in order, but do not need to visit every house
        // 
        // intuition:
        // iterate in reverse
        // dont need to check last house, as travel time is 0.

        int n = garbage.length;
        Boolean m = false, p = false, g = false;
        int res = garbage[0].length();

        for (int i = n - 1; i > 0; i--) {
            m |= garbage[i].contains("M");
            p |= garbage[i].contains("P");
            g |= garbage[i].contains("G");

            res += travel[i - 1] * ((m ? 1 : 0) + (p ? 1 : 0) + (g ? 1 : 0)) + garbage[i].length();
        }

        return res;
    }
}
// @lc code=end

