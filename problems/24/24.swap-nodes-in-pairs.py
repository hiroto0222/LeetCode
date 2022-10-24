#
# @lc app=leetcode id=24 lang=python3
#
# [24] Swap Nodes in Pairs
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        prev, curr = dummy, head

        while curr and curr.next:
            nextPair = curr.next.next
            second = curr.next

            # reverse
            second.next = curr
            curr.next = nextPair
            prev.next = second

            # update pointers
            prev = curr
            curr = nextPair

        return dummy.next

# @lc code=end

