#
# @lc app=leetcode id=230 lang=python3
#
# [230] Kth Smallest Element in a BST
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # return kth smallest node
        # 1. inorder traversal -> kth element
        # O(N) time, O(N) space

        def inOrderTraversal(node, lst):
            if not node:
                return
            inOrderTraversal(node.left, lst)
            lst.append(node.val)
            inOrderTraversal(node.right, lst)

        lst = []
        inOrderTraversal(root, lst)
        return lst[k - 1]
    
    # def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
    #     n = 0
    #     stack = []
    #     curr = root

    #     while curr and stack:
    #         while curr:
    #             stack.append(curr)
    #             curr = curr.left

    #         curr = stack.pop()
    #         n += 1
    #         if n == k:
    #             return curr.val
    #         curr = curr.right
  

# @lc code=end

