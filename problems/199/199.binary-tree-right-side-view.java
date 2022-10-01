import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }

    private void helper(TreeNode node, List<Integer> ans, int level) {
        if (node != null) {
            if (level == ans.size()) {
                ans.add(node.val);
            }
            helper(node.right, ans, level + 1);
            helper(node.left, ans, level + 1);
        }
    }
}
// @lc code=end

