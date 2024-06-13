/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
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
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        /*
         * check if leaf similar
         *
         * intuition:
         * - dfs to extract leaf nodes
         * - keep as string and compare
         *
         * O(N) time, O(N) space
         */

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // extract leaf nodes
        dfs(root1, sb1);
        dfs(root2, sb2);

        return sb1.toString().equals(sb2.toString());
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);

        if (node.left == null && node.right == null) {
            sb.append(node.val).append(',');
            return;
        }
    }
}
// @lc code=end
