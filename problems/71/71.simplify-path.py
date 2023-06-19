#
# @lc app=leetcode id=71 lang=python3
#
# [71] Simplify Path
#


# @lc code=start
class Solution:
    def simplifyPath(self, path: str) -> str:
        # convert absolute path to canonical path
        # canonical path
        # 1. path starts with single "/"
        # 2. any two directories are separated by a single slash '/'.
        # 3. path does not end with trailing "/"
        # 4. path only contains the directories on the path from the root directory to the target file or directory
        #    (i.e., no period '.' or double period '..')
        # ie:
        # path = "/home/"
        # -> "/home"
        # path = "/../"
        # -> "/"
        # path = "/home//foo/"
        # -> "/home/foo"
        #
        # approach:
        # stack -> keep track of directory
        # continue if /
        # if /./ -> do nth
        # if /../ -> pop stack
        # if /..dir/ -> append stack

        path += "/"
        stack = []
        curr = ""
        for c in path:
            if c == "/":
                if not curr:
                    continue
                if curr == ".." and stack:
                    stack.pop()
                if curr != ".." and curr != ".":
                    stack.append(curr)
                curr = ""
            else:
                curr += c

        if not stack:
            return "/"

        res = ""
        for val in stack:
            res += "/" + val

        return res


# @lc code=end
