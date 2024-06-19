/*
 * @lc app=leetcode id=2462 lang=java
 *
 * [2462] Total Cost to Hire K Workers
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        /*
         * return total cost to hire k workers
         * for each hiring session
         * 1. if candidates >= workers -> choose lowest cost worker with lowest index
         * 2. else:
         * - candidates are costs[:c+1] and costs[n-c-1:n+1]
         * - pick lowest cost worker with lowest index and remove
         *
         * intuition:
         * - keep 2 minheaps, left->right and right->left
         * - in this case we dont care about index as we always know which is larger
         *
         * O(NlogN) time, O(N) space
         */

        int l = 0;
        int r = costs.length - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // left side
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // right side

        long ans = 0;
        while (k-- > 0) {
            while (pq1.size() < candidates && l <= r) {
                pq1.offer(costs[l++]);
            }
            // duplicate values will never be added as we have a second l <= r check
            while (pq2.size() < candidates && l <= r) {
                pq2.offer(costs[r--]);
            }

            int cost1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int cost2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if (cost1 <= cost2) {
                ans += cost1;
                pq1.poll();
            } else {
                ans += cost2;
                pq2.poll();
            }
        }

        return ans;
    }
}
// @lc code=end
