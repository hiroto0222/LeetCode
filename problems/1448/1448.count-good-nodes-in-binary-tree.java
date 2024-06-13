/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

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
    public int goodNodes(TreeNode root) {
        /*
         * return number of good nodes
         * good if path from root to node X contain no nodes with val greater than X
         *
         * intuition:
         * - dfs
         *
         * O(N) time, O(N) worst O(logN) best
         * (worst case the height of the tree is N nodes)
         */

        if (root == null) {
            return 0;
        }

        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int currMax) {
        if (node == null) {
            return 0;
        }

        int cnt = 0;
        if (node.val >= currMax) {
            cnt = 1;
            currMax = node.val;
        }

        cnt += dfs(node.left, currMax);
        cnt += dfs(node.right, currMax);

        return cnt;
    }
}
// @lc code=end
