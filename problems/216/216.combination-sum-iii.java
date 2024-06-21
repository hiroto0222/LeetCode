/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        /*
         * find all valid combinations of k such that nums (1-9) sum up to n
         * each number (1-9) can only be used once.
         * if no valid combinations, return []
         *
         * intuition:
         * - dfs + backtrack
         *
         * O(9^k) time, worst case all possible combinations
         * O(k) space
         */

        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int k, int target, int curr, List<Integer> combo, List<List<Integer>> ans) {
        if (target == 0 && k == 0) {
            ans.add(new ArrayList<>(combo));
            return;
        }

        if (k == 0 || target < 0) {
            return;
        }

        for (int i = curr; i <= 9 && i <= target; i++) {
            combo.add(i);
            dfs(k - 1, target - i, i + 1, combo, ans);
            combo.remove(combo.size() - 1);
        }
    }
}
// @lc code=end
