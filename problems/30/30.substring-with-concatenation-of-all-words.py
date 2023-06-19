#
# @lc app=leetcode id=30 lang=python3
#
# [30] Substring with Concatenation of All Words
#


# @lc code=start
from collections import Counter


class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        # a concatenated substring of s is a substring that is a permutation of all words
        # return starting indices of all concatenated substrings in s
        # cannot use multiple of same word in words
        # all words are of same length
        # ie:
        # s = "barfoothefoobarman", words = ["foo","bar"]
        # i = [0,5] -> "barfoo"
        # i = [9,14] -> "foobar"
        # -> [0,9]
        # s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
        #
        # approach:
        # l -> keep tracks of current left index of substring
        # r -> iterate range(l, n - word_length + 1, word_length)
        # if cnts[s[r: r + word_length]] < 0, keep incrementing l till cnts[s[r: r + word_length]] >= 0
        # finally check if curr substring is equal to required substring size

        n, k, word_length = len(s), len(words), len(words[0])
        substring_size = k * word_length
        res = []

        for l in range(word_length):
            cnts = Counter(words)
            print(cnts, l)
            for r in range(l, n - word_length + 1, word_length):
                curr_word = s[r : r + word_length]
                cnts[curr_word] -= 1

                while cnts[curr_word] < 0:
                    left_word = s[l : l + word_length]
                    cnts[left_word] += 1
                    l += word_length

                if l + substring_size == r + word_length:
                    res.append(l)

        return res


# @lc code=end
