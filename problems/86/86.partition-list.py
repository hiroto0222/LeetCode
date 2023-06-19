#
# @lc app=leetcode id=86 lang=python3
#
# [86] Partition List
#


# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(
        self, head: Optional[ListNode], x: int
    ) -> Optional[ListNode]:
        # partition such that all nodes < x come before nodes >= x
        # ie:
        # head = [1,4,3,2,5,2], x = 3
        # [1,2,2,4,3,5]
        # approach:
        # 2 pointers, left right
        # left < x
        # right >= x
        # O(N) time, O(1) space

        if not head:
            return head

        leftDummy, rightDummy = ListNode(0), ListNode(0)
        left, right = leftDummy, rightDummy
        while head:
            temp = head.next
            head.next = None
            if head.val >= x:
                right.next = head
                right = right.next
            else:
                left.next = head
                left = left.next

            head = temp

        left.next = rightDummy.next
        return leftDummy.next


# @lc code=end
