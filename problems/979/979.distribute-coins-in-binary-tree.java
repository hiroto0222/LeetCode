/*
 * @lc app=leetcode id=979 lang=java
 *
 * [979] Distribute Coins in Binary Tree
 */

// @lc code=start
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int moves;

    public int distributeCoins(TreeNode root) {
        // binary tree
        // can move coins from parent to child, or from child to parent
        // min moves to make every node have exactly one coin
        // the sum of all node.val is n -> every node has exactly 1 coin
        // 
        // for each left and right subtree, take the absolute value of the excess coins
        // dfs O(N)

        this.dfs(root);
        return moves;
    }

    public int dfs(TreeNode root) {
        // base case
        if (root == null) return 0;

        // calc excess coins in left and right subtree
        int left = this.dfs(root.left);
        int right = this.dfs(root.right);
        moves += Math.abs(left) + Math.abs(right);

        return root.val + left + right - 1;
    }
}
// @lc code=end

