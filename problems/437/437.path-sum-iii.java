/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    Map<Long, Integer> hmap;
    int count;

    public int pathSum(TreeNode root, int targetSum) {
        /*
         * return number of paths where sum of vals along path equal targetSum
         *
         * intuition:
         * - dfs
         * - keep track of prefix sum in hash table with the number of paths
         * - a path for targetSum can be found by either
         * - 1. have seen a prefix sum where hash(currPrefixSum - targetSum) exists.
         * - 2. currPrefixSum == targetSum
         *
         * O(N) time, O(N) worst case
         */

        if (root == null) {
            return 0;
        }

        hmap = new HashMap<>();
        count = 0;

        dfs(root, 0, targetSum);

        return count;
    }

    private void dfs(TreeNode node, long prefixSum, int targetSum) {
        if (node == null) {
            return;
        }

        prefixSum += node.val;

        // if map contains sum (prefixSum - targetSum), then add number of paths to cnt
        if (hmap.containsKey(prefixSum - targetSum)) {
            count += hmap.get(prefixSum - targetSum);
        }

        // if prefixSum equals targetSum, then increment count
        if (prefixSum == targetSum) {
            count++;
        }

        // update prefixSum upto current node and increment path count
        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

        // traverse
        dfs(node.left, prefixSum, targetSum);
        dfs(node.right, prefixSum, targetSum);

        // backtrack
        hmap.put(prefixSum, hmap.get(prefixSum) - 1);
    }
}
// @lc code=end
