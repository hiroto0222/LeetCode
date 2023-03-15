#
# @lc app=leetcode id=206 lang=python3
#
# [206] Reverse Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    #     # reverse linked list
        
    #     prev = None
    #     while head:
    #         temp = head.next
    #         head.next = prev
    #         prev = head
    #         head = temp
        
    #     return prev
    
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # recursive
        
        def helper(prev, curr):
            if not curr:
                return prev
            
            next = curr.next
            curr.next = prev

            helper(curr, next)

        return helper(None, head)


# @lc code=end

