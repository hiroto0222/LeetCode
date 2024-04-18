#
# @lc app=leetcode id=68 lang=python3
#
# [68] Text Justification
#


# @lc code=start
class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        # words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
        # [
        #    "This    is    an",
        #    "example  of text",
        #    "justification.  "
        # ]

        res = []
        line, length = [], 0
        i = 0

        while i < len(words):
            # if curr length + required spaces + length words[i] > maxWidth
            if length + len(line) + len(words[i]) > maxWidth:
                extra_space = maxWidth - length
                spaces = extra_space // max(len(line) - 1, 1)
                remaining = extra_space % max(len(line) - 1, 1)

                for j in range(max(len(line) - 1, 1)):
                    line[j] += " " * spaces
                    if remaining > 0:
                        line[j] += " "
                        remaining -= 1

                res.append("".join(line))
                line, length = [], 0

            line.append(words[i])
            length += len(words[i])
            i += 1

        # handle last line
        last_line = " ".join(line)
        trail_space = maxWidth - len(last_line)
        last_line += " " * trail_space
        res.append(last_line)

        return res


# @lc code=end
