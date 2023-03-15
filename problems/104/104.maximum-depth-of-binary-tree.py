#
# @lc app=leetcode id=104 lang=python3
#
# [104] Maximum Depth of Binary Tree
#

# @lc code=start
from collections import deque

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # recursive DFS

        if not root:
            return 0
        
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
    
    # def maxDepth(self, root: Optional[TreeNode]) -> int:
    #     # iterative BFS

    #     if not root:
    #         return 0
        
    #     depth = 0
    #     q = deque([root])
    #     while q:
    #         for _ in range(len(q)):
    #             curr = q.popleft()
    #             if curr.left:
    #                 q.append(curr.left)
    #             if curr.right:
    #                 q.append(curr.right)
    #         depth += 1
        
    #     return depth
        
# @lc code=end

