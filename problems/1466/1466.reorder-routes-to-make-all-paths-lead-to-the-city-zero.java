/*
 * @lc app=leetcode id=1466 lang=java
 *
 * [1466] Reorder Routes to Make All Paths Lead to the City Zero
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minReorder(int n, int[][] connections) {
        /*
         * reorient edges such that each node can reach node 0
         * return minimum number of edges to change
         * guranteed that each node can reach node 0
         * n - 1 edges, so connected, and no loops
         *
         * intuition:
         * - keep track of edges
         * - keep track of neighbors
         *
         * O(N) time, O(N) space
         */

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            int u = c[0], v = c[1];
            graph.get(u).add(new int[] { v, 1 }); // reachable neighbor
            graph.get(v).add(new int[] { u, 0 }); // unreachable neighbor
        }

        int ans = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // start from node 0

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (visited[curr]) {
                continue;
            }

            visited[curr] = true;
            for (int[] neighbor : graph.get(curr)) {
                if (!visited[neighbor[0]]) {
                    q.add(neighbor[0]);

                    if (neighbor[1] == 1) {
                        // must reverse
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
// @lc code=end
