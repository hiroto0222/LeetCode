/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 */

// @lc code=start
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        /*
         * return true, if the tree has a root-to-leaf path that adds up to targetSum.
         * leaf is a node with no children.
         * 0 <= n <= 5000
         *
         * intuition:
         * - recursive brute force dfs
         *
         * O(N) time, O(N) space.
         */

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
// @lc code=end
