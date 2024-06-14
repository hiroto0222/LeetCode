/*
 * @lc app=leetcode id=1372 lang=java
 *
 * [1372] Longest ZigZag Path in a Binary Tree
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
    public int longestZigZag(TreeNode root) {
        /*
         * return longest zigzag path
         * - does not have to start from root node
         *
         * intuition:
         * - dfs, backtrack
         * -
         *
         * O(N) time, O(N) recursive stack
         */

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, true, 0);
        int right = dfs(root.right, false, 0);

        return Math.max(left, right);
    }

    private int dfs(TreeNode node, boolean isLeft, int height) {
        if (node == null) {
            return height;
        }

        if (isLeft) {
            // if prev left go right
            height = Math.max(height, dfs(node.right, false, height + 1));
            // reset and try left
            height = Math.max(height, dfs(node.left, true, 0));
        } else {
            // if prev right go left
            height = Math.max(height, dfs(node.left, true, height + 1));
            // reset and try right
            height = Math.max(height, dfs(node.right, false, 0));
        }

        return height;
    }
}
// @lc code=end
