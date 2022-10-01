#
# @lc app=leetcode id=199 lang=python3
#
# [199] Binary Tree Right Side View
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
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # root + BFS most right

        if not root:
            return []

        ans = []
        q = deque([root])

        while q:
            n = len(q)
            for i in range(n):
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                if i == n - 1:
                    ans.append(curr.val)
        
        return ans
        
        
# @lc code=end

