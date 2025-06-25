/*
 * @lc app=leetcode id=2383 lang=java
 *
 * [2383] Minimum Hours of Training to Win a Competition
 */

// @lc code=start
class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // n opponents in order
        // ith opponent has energy[i] and experience[i]
        // can win if strictly greater
        // defeating ith opponent increases experience but decreases energy
        // ex:
        // [1,4,3,2] 5
        // [2,6,3,1] 3
        // 6 + 2
        
        int n = energy.length;
        int res = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += energy[i];
        }
        res += Math.max(sum - initialEnergy + 1, 0);

        for (int i = 0; i < n; i++) {
            int diff = experience[i] - initialExperience + 1;
            if (diff > 0) {
                initialExperience += diff;
                res += diff;
            }
            initialExperience += experience[i];
        }

        return res;
    }
}
// @lc code=end

