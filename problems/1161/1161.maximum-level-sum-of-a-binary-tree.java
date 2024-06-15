/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

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
    public int maxLevelSum(TreeNode root) {
        /*
         * return smallest level x, such that sum of nodes in level x are maximal
         *
         * intuition:
         * - BFS
         *
         * O(N) time, O(N) space
         */

        Queue<TreeNode> q = new LinkedList<>();
        int currMax = Integer.MIN_VALUE;
        int currMaxLevel = 0;

        q.add(root);
        int currLevel = 0;

        while (!q.isEmpty()) {
            currLevel++;
            int size = q.size();
            int currSum = 0;
            while (size-- > 0) {
                TreeNode curr = q.poll();
                currSum += curr.val;

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            if (currSum > currMax) {
                currMax = currSum;
                currMaxLevel = currLevel;
            }
        }

        return currMaxLevel;
    }
}
// @lc code=end
