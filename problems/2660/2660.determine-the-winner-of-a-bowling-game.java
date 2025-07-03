/*
 * @lc app=leetcode id=2660 lang=java
 *
 * [2660] Determine the Winner of a Bowling Game
 */

// @lc code=start
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        // scoring given x[i] pins on ith turn:
        // - 2 * x[i] if player hits 10 pins in either (i - 1) or (i - 2)
        // - otherwise x[i]
        // score of player is sum of values on n turns
        // ex:
        // player1 = [5,10,3,2], player2 = [6,5,7,3]
        // i = 0 -> p1 = 5, p2 = 6
        // i = 1 -> p1 = 15, p2 = 11
        // i = 2 -> p1 = 21, p2 = 18
        // i = 3 -> p1 = 25, p2 = 21
        
        int n = player1.length;
        int p1 = 0, p2 = 0;
        for (int i = 0; i < n; i++) {
            p1 += checkHasStrikes(i, player1) ? player1[i] * 2 : player1[i];
            p2 += checkHasStrikes(i, player2) ? player2[i] * 2 : player2[i];
        }

        return p1 > p2 ? 1 : p1 < p2 ? 2 : 0; 
    }

    private boolean checkHasStrikes(int i, int[] player) {
        return (i - 2 >= 0 && player[i - 2] == 10) || (i - 1 >= 0 && player[i - 1] == 10);
    }
}
// @lc code=end

