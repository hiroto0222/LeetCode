/*
 * @lc app=leetcode id=3238 lang=java
 *
 * [3238] Find the Number of Winning Players
 */

// @lc code=start
class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        // player[i] wins if they pick at least i + 1 balls of same color
        // return number of players who win the game

        int[][] players = new int[n][11];
        boolean[] winners = new boolean[n];
        int res = 0;
        for (int i = 0; i < pick.length; i++) {
            int player = pick[i][0];
            int[] curr = players[player];
            curr[pick[i][1]]++;

            if (curr[pick[i][1]] > player && !winners[player]) {
                res++;
                winners[player] = true;
            }
        }

        return res;
    }
}
// @lc code=end

