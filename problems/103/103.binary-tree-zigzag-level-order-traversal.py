#
# @lc app=leetcode id=103 lang=python3
#
# [103] Binary Tree Zigzag Level Order Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # level order with stack
        # flip between reverse true/false

        if not root:
            return []

        q = deque()
        q.append(root)
        res = []

        while q:
            curr = []
            for _ in range(len(q)):
                node = q.popleft()
                curr.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            
            res.append(curr)

        return list(curr if idx % 2 == 0 else reversed(curr) for idx, curr in enumerate(res))
        
        
# @lc code=end

