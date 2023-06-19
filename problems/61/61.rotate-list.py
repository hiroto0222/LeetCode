#
# @lc app=leetcode id=61 lang=python3
#
# [61] Rotate List
#


# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(
        self, head: Optional[ListNode], k: int
    ) -> Optional[ListNode]:
        # rotate the list to the right by k places
        # ie: head = [1,2,3,4,5], k = 2
        # -> head = [4,5,1,2,3]
        # 2 pointers
        # start right till k == 0, then start left
        # once right reaches null, left reaches n - k
        # start = left.next
        # left.next = null
        # right.next = head

        if not head:
            return head

        # get length
        size = 0
        curr = head
        while curr:
            curr = curr.next
            size += 1

        k %= size

        if k == 0:
            return head

        right = head
        while k > 0:
            k -= 1
            right = right.next

        left = head
        while right.next:
            left = left.next
            right = right.next

        start = left.next
        left.next = None
        right.next = head

        return start


# @lc code=end
