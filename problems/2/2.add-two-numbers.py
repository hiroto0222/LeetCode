#
# @lc app=leetcode id=2 lang=python3
#
# [2] Add Two Numbers
#


# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(
        self, l1: Optional[ListNode], l2: Optional[ListNode]
    ) -> Optional[ListNode]:
        # 2 non-empty linked lists
        # digits stored in reverse order
        # ie:
        # l1 = [2,4,3], l2 = [5,6,4] (342 + 465 = 807)
        # while l1 or l2, keep adding and keep track of carry forward
        # whatever remains, keep adding
        # ie:
        # 9999999 + 9999 = 10009998

        dummyNode = ListNode(0)
        head = dummyNode
        carry = False
        while l1 and l2:
            curr = l1.val + l2.val

            if carry:
                curr += 1
                carry = False

            if curr > 9:
                carry = True
                curr %= 10

            head.next = ListNode(curr)
            head = head.next
            l1 = l1.next
            l2 = l2.next

        while l1:
            curr = l1.val
            if carry:
                curr += 1
                carry = False

            if curr > 9:
                carry = True
                curr %= 10

            head.next = ListNode(curr)
            head = head.next
            l1 = l1.next

        while l2:
            curr = l2.val
            if carry:
                curr += 1
                carry = False

            if curr > 9:
                carry = True
                curr %= 10

            head.next = ListNode(curr)
            head = head.next
            l2 = l2.next

        if carry:
            head.next = ListNode(1)

        return dummyNode.next


# @lc code=end
