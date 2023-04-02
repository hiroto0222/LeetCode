#
# @lc app=leetcode id=1382 lang=python3
#
# [1382] Balance a Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        # inorder traverse
        # construct balanced tree

        inorder = []

        def dfs(root):
            if not root:
                return

            dfs(root.left)
            inorder.append(root.val)
            dfs(root.right)

        def build(nodes, start, end):
            if start > end:
                return

            mid = (start + end) // 2
            root = TreeNode(nodes[mid])
            root.left = build(nodes, start, mid - 1)
            root.right = build(nodes, mid + 1, end)

            return root

        dfs(root)
        return build(inorder, 0, len(inorder) - 1)


# @lc code=end

