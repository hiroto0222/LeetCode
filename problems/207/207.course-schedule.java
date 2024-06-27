/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
         * return true if you can finish all courses, otherwise false.
         * prerequisites[i] = [a, b] -> must take b before a
         *
         * intuition:
         * - graph problem
         * - cannot finish all courses if a cycle between them exists
         * - detect cycle in a directed graph
         *
         * O(N) time, O(N) space
         */

        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            adj.putIfAbsent(prerequisite[0], new ArrayList<>());
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        // detect cycle
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses]; // keeps track of visited nodes in recursion

        for (int node = 0; node < numCourses; node++) {
            if (hasCycle(adj, visited, recStack, node)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(HashMap<Integer, List<Integer>> adj, boolean[] visited, boolean[] recStack, int node) {
        // if node already visited in dfs
        if (recStack[node]) {
            return true;
        }
        // if node already visited
        if (visited[node]) {
            return false;
        }

        // mark current node as visited and add to dfs stack
        visited[node] = true;
        recStack[node] = true;

        // dfs
        if (adj.containsKey(node)) {
            List<Integer> neighbors = adj.get(node);
            for (int neighbor : neighbors) {
                if (hasCycle(adj, visited, recStack, neighbor)) {
                    return true;
                }
            }
        }

        // backtrack
        recStack[node] = false;

        return false;
    }
}
// @lc code=end
