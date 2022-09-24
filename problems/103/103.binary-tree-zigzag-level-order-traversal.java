import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        int level = 0;

        if (root != null) q.offerFirst(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if(level % 2 == 0) {
                    TreeNode cur = q.pollLast();
                    list.add(cur.val);
                    if(cur.left != null) q.offerFirst(cur.left);
                    if(cur.right != null) q.offerFirst(cur.right);
                } else {
                    TreeNode cur = q.pollFirst();
                    list.add(cur.val);
                    if(cur.right != null) q.offerLast(cur.right);
                    if(cur.left != null) q.offerLast(cur.left);
                }
            }
            res.add(list);
            level++;
        }

        return res;
    }
}
// @lc code=end

