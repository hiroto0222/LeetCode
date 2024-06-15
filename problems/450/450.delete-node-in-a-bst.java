/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        /*
         * delete node from BST
         *
         * intuition:
         * - search for node using DFS
         * cases of deletion
         * 1. if leaf, set curr null
         * 2. if only left child, replace curr with left child
         * 3. if only right child, replace curr with right child
         * 4. if left, right child, replace curr with smallest value from right child
         */

        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // case 1. leaf
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2. only left child
            else if (root.right == null) {
                return root.left;
            }
            // case 3. only right child
            else if (root.left == null) {
                return root.right;
            }
            // case 4. both child, find smallest value from right
            else {
                // replace curr node with inorder successor
                TreeNode inorderSuccessor = findInorderSuccessor(root.right);
                root.val = inorderSuccessor.val;
                // delete replaced node from subtree
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    private TreeNode findInorderSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
// @lc code=end
