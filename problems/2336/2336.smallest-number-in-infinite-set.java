/*
 * @lc app=leetcode id=2336 lang=java
 *
 * [2336] Smallest Number in Infinite Set
 */

// @lc code=start

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class SmallestInfiniteSet {
    /*
     * set that contains all positive integers
     *
     * intuition:
     * - smallest set of positive integers can just be an Integer being incremented
     * - have int next
     * - addBack should add to a min-heap, if num < next
     * - popSmallest pops from min-heap if not empty, else returns next++
     *
     * popSmallest -> O(1) time
     * addBack -> O(logN) time
     * O(N) space
     */

    private int next = 1;
    private Queue<Integer> minHeap;
    private Set<Integer> seen;

    public SmallestInfiniteSet() {
        this.minHeap = new PriorityQueue<>();
        this.seen = new HashSet<>();
    }

    // removes and returns the smallest integer contained in infinite set
    public int popSmallest() {
        // pop from minheap if not empty
        if (!this.minHeap.isEmpty()) {
            int val = this.minHeap.poll();
            this.seen.remove(val);
            return val;
        }
        // else return next and increment
        return next++;
    }

    // adds integer back into infinite set, if not already in set (no duplicates)
    public void addBack(int num) {
        if (num < this.next && !this.seen.contains(num)) {
            this.minHeap.add(num);
            this.seen.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
// @lc code=end
