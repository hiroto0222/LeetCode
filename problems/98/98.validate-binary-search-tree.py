#
# @lc app=leetcode id=98 lang=python3
#
# [98] Validate Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def isValidBST(self, root: Optional[TreeNode]) -> bool:
    #     # DFS, keeping track of curr min and max
    #     # O(N) time, O(N) space

    #     def helper(root, curr_min, curr_max):
    #         if not root:
    #             return True
    #         if not (root.val < curr_max and root.val > curr_min):
    #             return False
            
    #         return helper(root.left, curr_min, root.val) and helper(root.right, root.val, curr_max)
        
    #     return helper(root, -float("inf"), float("inf"))

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # Inorder Traversal of BST -> ascending order
        # O(N) time, O(N) space

        def inOrderTraversal(root, lst):
            if not root: return
            inOrderTraversal(root.left, lst)
            lst.append(root.val)
            inOrderTraversal(root.right, lst)
        
        lst = []
        inOrderTraversal(root, lst)
        for i in range(1, len(lst)):
            if lst[i - 1] >= lst[i]:
                return False
        
        return True


# @lc code=end
