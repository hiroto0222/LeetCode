#
# @lc app=leetcode id=133 lang=python3
#
# [133] Clone Graph
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        oldToNew = {}

        def dfs(node):
            if node not in oldToNew:
                oldToNew[node] = Node(node.val)

            for neighbor in node.neighbors:
                if neighbor in oldToNew:
                    oldToNew[node].neighbors.append(oldToNew[neighbor])
                else:
                    dfs(neighbor)
                    oldToNew[node].neighbors.append(oldToNew[neighbor])

        dfs(node)
        return oldToNew[node]

# @lc code=end
