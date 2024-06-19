/*
 * @lc app=leetcode id=2542 lang=java
 *
 * [2542] Maximum Subsequence Score
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    // nums1 -> a, nums2 -> b
    record Pair(int a, int b) {
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        /*
         * score is calculated as
         * where i -> k is a subsequence of indices from nums1 of length k
         * (nums1[i0] +...+ nums1[ik - 1]) * min(nums2[i0], ... ,nums2[ik - 1])
         * return max score
         *
         * nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
         * sorted by nums2
         * nums1 = [3,1,3,2]
         * nums2 = [1,2,3,4]
         *
         * intuition:
         * - iterate all pairs (A[i], B[i]) with B[i] from big to small
         * - keep priority queue with max size of k + 1
         * - want to maximize sum * min of subsequence pair
         * - atmost n - k - 1 min values
         * - for each n-k-1 min values we want max sum
         */

        int n = nums1.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }

        // sort by descending order of nums2
        Arrays.sort(pairs, (x, y) -> y.b - x.b);

        Queue<Integer> pq = new PriorityQueue<>(k + 1);
        long res = 0;
        long sum = 0;

        for (Pair p : pairs) {
            pq.add(p.a);
            sum += p.a;
            // if size exceeds k, pop min value
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            // if size equals k, check if max
            // in this case, p.b will always be the min nums2 value,
            // and the sum will be the curr maximum
            if (pq.size() == k) {
                res = Math.max(res, sum * p.b);
            }
        }

        return res;
    }
}
// @lc code=end
