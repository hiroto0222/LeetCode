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
        // iterate every house and greedily add mins

        int n = garbage.length;
        int[] timeTravel = new int[3]; // M, P, G
        int[] timeCollect = new int[3];
        int res = 0;

        int curr = 0;
        for (int i = 0; i < n; i++) {
            String s = garbage[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'M') {
                    timeTravel[0] = curr;
                    timeCollect[0]++;
                } else if (s.charAt(j) == 'P') {
                    timeTravel[1] = curr;
                    timeCollect[1]++;
                } else {
                    timeTravel[2] = curr;
                    timeCollect[2]++;
                }
            }

            if (i < n - 1) {
                curr += travel[i];
            }
        }

        for (int i = 0; i < 3; i++) {
            res += timeTravel[i] + timeCollect[i];
        }

        return res;
    }
}
// @lc code=end

