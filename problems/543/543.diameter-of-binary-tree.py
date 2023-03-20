#
# @lc app=leetcode id=543 lang=python3
#
# [543] Diameter of Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = 0

        def dfs(node):
            nonlocal diameter

            if not node:
                return 0
            
            left = dfs(node.left)
            right = dfs(node.right)

            diameter = max(left + right, diameter)

            return max(left, right) + 1
        
        dfs(root)
        return diameter


# @lc code=end
