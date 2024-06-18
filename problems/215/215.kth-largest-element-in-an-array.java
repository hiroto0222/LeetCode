/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
         * return the kth largest element in nums
         *
         * intuition 1:
         * - sort and return element k
         * - O(NlogN) time
         *
         * intuition 2:
         * - min heap to keep track k max elements in nums
         * - when minheap size > k, pop
         * - after iterating all nums, minheap.poll() -> kth element
         *
         * O(NlogK) time, O(N) space
         */

        Queue<Integer> pq = new PriorityQueue<>(); // min-heap
        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // head is the kth max element
        return pq.peek();
    }
}
// @lc code=end
