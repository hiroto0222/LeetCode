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

    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int currRoom, boolean[] visited) {
        visited[currRoom] = true;
        for (int room : rooms.get(currRoom)) {
            if (!visited[room]) {
                dfs(rooms, room, visited);
            }
        }
    }
}
// @lc code=end
