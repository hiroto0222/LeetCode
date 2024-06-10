/*
 * @lc app=leetcode id=933 lang=java
 *
 * [933] Number of Recent Calls
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    /*
     * ping(1) -> return all requests within range [1-3000, 1] -> 1
     * ping(2) -> return all requests within range [2-3000, 2] -> 2
     *
     * intuition:
     * - queue to keep track of requests made
     * - for each ping(t), check requests from oldest to new
     * - remove any requests that have time < t - 3000
     *
     * O(N) time, O(N) space
     */

    Queue<Integer> requests;

    public RecentCounter() {
        this.requests = new LinkedList<>();
    }

    public int ping(int t) {
        this.requests.add(t);
        while (this.requests.peek() < t - 3000) { // peek left most
            this.requests.poll(); // popleft
        }
        return this.requests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end
