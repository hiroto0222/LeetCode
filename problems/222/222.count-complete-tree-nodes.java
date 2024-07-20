/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        /*
         * every level except last level is completely filled.
         * return number of nodes in tree in < O(N) time.
         *
         * intuition:
         * - if all levels are completely filled, it is a PBT so 2^N - 1;
         * - can do so by checking left most and right most heights.
         * - if not PBT, then find subtrees that are PBTs
         *
         * O((logN)^2) time, O(logN) space.
         */

        if (root == null) {
            return 0;
        }

        // find left most height
        int leftHeight = 0;
        TreeNode curr = root;
        while (curr != null) {
            leftHeight++;
            curr = curr.left;
        }

        // find right most height
        int rightHeight = 0;
        curr = root;
        while (curr != null) {
            rightHeight++;
            curr = curr.right;
        }

        // leftHeight == rightHeight, then perfect binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        // else it recursively count the subtrees that are perfect binary trees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
// @lc code=end
