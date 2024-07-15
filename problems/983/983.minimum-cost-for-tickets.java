/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        /*
         * 1 day pass -> costs[0]
         * 7 day pass -> costs[1] (if buy on day 2 can travel till day 8)
         * 30 day pass -> costs[2]
         * return min number of dollars to travel every day in days.
         *
         * intuition:
         * - brute force iterative dp.
         * - dp[i] = min(cost[0] + dp[i-1], cost[1] + dp[i-7], cost[2] + dp[i-30])
         *
         * O(N) time, O(N) space.
         */

        int n = days.length;
        int maxDay = days[n - 1];
        int[] dp = new int[maxDay + 1]; // upto max day

        int i = 0;
        for (int day = 1; day <= maxDay; day++) {
            if (day == days[i]) {
                int cost1 = costs[0] + dp[Math.max(0, day - 1)];
                int cost2 = costs[1] + dp[Math.max(0, day - 7)];
                int cost3 = costs[2] + dp[Math.max(0, day - 30)];
                dp[day] = Math.min(cost1, Math.min(cost2, cost3));
                i++;
            } else {
                dp[day] = dp[day - 1];
            }
        }

        return dp[maxDay];
    }
}
// @lc code=end
