/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    public int rob(TreeNode root) {
        /*
         * given binary tree, find max amount of money.
         * cannot rob 2 adjacent nodes.
         *
         * intution:
         * - dfs with 2 states, with root or without root.
         * - for each node, return the max for with root and without root.
         * - returns [withRoot, withoutRoot]
         *
         * O(N) time, O(N) recursive space.
         */

        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // withRoot -> root value + max of without root for both left and right
        int withRoot = root.val + left[1] + right[1];
        // withoutRoot -> max(left) + max(right)
        int withoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { withRoot, withoutRoot };
    }
}
// @lc code=end
