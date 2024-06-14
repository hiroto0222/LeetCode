/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * find lowest common ancestor of 2 given nodes
         * - root is always a common ancestor of 2 given nodes
         *
         * intuition:
         * cases of lowest common ancestor
         * 1. nodes are in different subtrees
         * 2. if in same subtree, lowest common ancestor is either p or q
         *
         * 1. start from root and find a node that is either p or q
         * 2. if node x is p or q, the other is either a descendant of x (in which case
         * the lowest common ancestor is x) or the node is in the other subtree
         *
         * O(N) time, O(N) space
         */

        if (root == null) {
            return null;
        }

        // if we find p or q return it
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if left and right are both non-null, then current node is LCA
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
// @lc code=end
