/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        /*
         * return true if can visit all rooms, false otherwise
         *
         * intuition:
         * - bfs
         * - keep track of visited rooms using boolean array
         *
         * O(N) time, O(N) space
         */

        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>(); // holds the curr accessible rooms
        q.add(0);

        while (!q.isEmpty()) {
            int currKey = q.poll();
            if (!visited[currKey]) {
                visited[currKey] = true; // mark room as visited

                for (int k : rooms.get(currKey)) {
                    if (!visited[k]) {
                        q.add(k);
                    }
                }
            }

        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
