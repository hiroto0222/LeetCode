/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        /*
         * return unique BSTs with n unique nodes from 1 to n.
         *
         * intuition:
         * - recursive brute force with caching.
         *
         * O(C(n)) time where C is Catalan number, O(C(n)) space
         */

        if (n == 0) {
            return new ArrayList<>();
        }

        Map<String, List<TreeNode>> dp = new HashMap<>();
        return helper(1, n, dp);
    }

    private List<TreeNode> helper(int start, int end, Map<String, List<TreeNode>> dp) {
        // if already computed subtree for range [start,end], return from dp.
        String key = start + "-" + end;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        List<TreeNode> trees = new ArrayList<>();
        // end of range, so add null.
        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int rootVal = start; rootVal <= end; rootVal++) {
            // construct all possible left subtrees
            List<TreeNode> leftTrees = helper(start, rootVal - 1, dp);
            // construct all possible right subtrees
            List<TreeNode> rightTrees = helper(rootVal + 1, end, dp);

            for (TreeNode leftNode : leftTrees) {
                for (TreeNode rightNode : rightTrees) {
                    TreeNode root = new TreeNode(rootVal, leftNode, rightNode);
                    trees.add(root);
                }
            }
        }

        dp.put(key, trees);
        return trees;
    }
}
// @lc code=end
