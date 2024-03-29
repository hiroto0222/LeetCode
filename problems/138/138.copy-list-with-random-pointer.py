#
# @lc app=leetcode id=138 lang=python3
#
# [138] Copy List with Random Pointer
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""


class Solution:
    def copyRandomList(self, head: "Optional[Node]") -> "Optional[Node]":
        seen = {None: None}
        curr = head
        while curr:
            seen[curr] = Node(curr.val)
            curr = curr.next

        curr = head
        while curr:
            copy = seen[curr]
            copy.next = seen[curr.next]
            copy.random = seen[curr.random]
            curr = curr.next

        return seen[head]


# @lc code=end
