/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
         * return the answers to all queries
         * if the answer cannot be determined, return -1.0
         * no division by zero, or contradictions
         *
         * given a/b = 2.0, b/c = 3.0
         * a/c? a->b->c 2.0*3.0 = 6.0
         * b/a? 1/2.0 = 0.5
         * a/e? undefined -1.0
         * a/a? 1
         *
         * intuition:
         * - create a graph to keep track of equations and its inverse
         * - "a" -> Pair("b", 2.0)
         * - for a query, find a way to get to from query[0] -> query[1] using dfs
         * - multiply every value on the way
         * - keep a visited set so we dont infinite loop (ie: b/c->c/b->b/c...)
         * - if no path found, return -1.0
         */

        int n = equations.size();
        int m = queries.size();

        Map<String, List<Pair<String, Double>>> graph = new HashMap<>();

        // populate graph
        for (int i = 0; i < n; i++) {
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Pair(v, val));
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(new Pair(u, 1 / val)); // inverse
        }

        double[] ans = new double[m];
        // process queries
        for (int i = 0; i < m; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            // if graph does not contain u, then always undefined
            ans[i] = -1;
            if (!graph.containsKey(u)) {
                continue;
            }

            // else check to see if not undefined
            dfs(graph, u, v, 1, new HashSet<>(), ans, i);
        }

        return ans;
    }

    private void dfs(Map<String, List<Pair<String, Double>>> graph, String u, String v, double curr,
            Set<String> visited, double[] ans, int i) {
        if (u.equals(v)) {
            ans[i] = curr;
            return;
        }

        visited.add(u);
        for (Pair<String, Double> p : graph.get(u)) {
            if (!visited.contains(p.getKey())) {
                dfs(graph, p.getKey(), v, curr * p.getValue(), visited, ans, i);
            }
        }
    }
}
// @lc code=end
