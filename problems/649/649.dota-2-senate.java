/*
 * @lc app=leetcode id=649 lang=java
 *
 * [649] Dota2 Senate
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        /*
         * - each senator has the right to vote
         * - senators earlier in the queue have a higher priority
         *
         * observation:
         * - as senator's earlier in the queue have priority,
         * - each senator should ban the next opposing party member
         * - this will continue until either party is empty.
         *
         * intuition:
         * - use a queue to keep track of radiant and dire party members
         * - the queue will store the index of the senate
         * - every round, popleft from both and see which index is lower
         * - the lower index wins, so gets pushed back to the queue,
         * - the pushed back winner has the index of the n, which gets incremented
         * - whilst the loser is not
         *
         * O(N) time, O(N) space
         */

        Queue<Integer> radiants = new LinkedList<>(); // active radiant senates
        Queue<Integer> dires = new LinkedList<>(); // active dire senates

        // populate initial queue
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }

        int n = senate.length();
        while (!radiants.isEmpty() && !dires.isEmpty()) {
            int currRad = radiants.poll();
            int currDir = dires.poll();

            if (currRad < currDir) {
                radiants.add(n);
            } else {
                dires.add(n);
            }

            n++;
        }

        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
}
// @lc code=end
