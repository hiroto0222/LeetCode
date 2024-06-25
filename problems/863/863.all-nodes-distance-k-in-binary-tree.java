/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        /*
         * return array of all nodes that have a distance k from target node
         *
         * intuition:
         * - dfs till target found
         * - bfs from target? but no pointers to parent so cant
         * - can create adjacency list of all nodes using bfs
         * - bfs to create adjacency list, then bfs from target
         *
         * O(N) time, O(N) space
         */

        List<Integer> res = new ArrayList<>();
        // create adjacency list
        HashMap<TreeNode, List<TreeNode>> graph = createGraph(root);

        // bfs from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        q.offer(target);
        seen.add(target);
        int steps = 0;

        while (!q.isEmpty()) {
            // if we are beyond k then exit
            if (steps > k) {
                break;
            }
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                if (steps == k) {
                    res.add(curr.val);
                }
                // add neighbors to q
                for (TreeNode v : graph.get(curr)) {
                    if (!seen.contains(v)) {
                        q.offer(v);
                        seen.add(v);
                    }
                }
            }
            // increment step
            steps++;
        }

        return res;
    }

    // createGraph returns an adjacency list as a hashmap
    private HashMap<TreeNode, List<TreeNode>> createGraph(TreeNode root) {
        HashMap<TreeNode, List<TreeNode>> adj = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // bfs and create adjacency list of all nodes
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                adj.putIfAbsent(curr, new ArrayList<>());

                // add parent -> child and child -> parent
                if (curr.left != null) {
                    adj.get(curr).add(curr.left);
                    adj.putIfAbsent(curr.left, new ArrayList<>());
                    adj.get(curr.left).add(curr);
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    adj.get(curr).add(curr.right);
                    adj.putIfAbsent(curr.right, new ArrayList<>());
                    adj.get(curr.right).add(curr);
                    q.add(curr.right);
                }
            }
        }

        return adj;
    }
}
// @lc code=end
