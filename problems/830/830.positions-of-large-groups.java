/*
 * @lc app=leetcode id=830 lang=java
 *
 * [830] Positions of Large Groups
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        /*
         * return intervals of every large group, sorted by start index
         * large group -> j - i >= 2
         *
         * intuition:
         * - 2 pointers
         *
         * O(N) time, O(1) space
         */

        int n = s.length();
        List<List<Integer>> res = new ArrayList<>();

        if (n < 3) {
            return res;
        }

        int i = 0, j = 1;
        while (i < n) {
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            if (j - i >= 3) {
                List<Integer> curr = new ArrayList<>();
                curr.add(i);
                curr.add(j - 1);
                res.add(curr);
            }

            i = j;
            j = i + 1;
        }

        return res;
    }
}
// @lc code=end
