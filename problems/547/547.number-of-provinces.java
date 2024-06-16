/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        /*
         * return total number of provinces
         * a province is a group of connected nodes
         *
         * intuition:
         * - each dfs is a province
         * - mark cities as visited, do not revisit
         *
         * O(N) time, O(N) recursive space
         */

        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int city = 0; city < isConnected.length; city++) {
            if (!visited[city]) {
                provinces++;
                dfs(isConnected, city, visited);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, int city, boolean[] visited) {
        visited[city] = true;
        for (int other = 0; other < isConnected[city].length; other++) {
            if (isConnected[city][other] == 1 && !visited[other]) {
                dfs(isConnected, other, visited);
            }
        }
    }
}
// @lc code=end
