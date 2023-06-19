/*
 * @lc app=leetcode id=30 lang=golang
 *
 * [30] Substring with Concatenation of All Words
 */

package solution

// @lc code=start
func findSubstring(s string, words []string) []int {
	// sliding window
	// l -> keep track of start of curr substring
	// r -> iterate in increments of word_length
	// if s[r: r+word_length] is in words
	//    and cnts[word] < 0:
	// 		keep incrementing l till cnt[words] >= 0
	// for each iteration of r, check if substring equal to required substring length

	n, k, word_length := len(s), len(words), len(words[0])
	substring_size := k * word_length
	res := make([]int, 0)

	for l := 0; l < word_length; l++ {
		curr_cnts := make(map[string]int)
		for _, word := range words {
			curr_cnts[word]++
		}

		curr_l := l
		for r := curr_l; r < n-word_length+1; r += word_length {
			curr_word := s[r : r+word_length]
			curr_cnts[curr_word]--

			for curr_cnts[curr_word] < 0 {
				word_to_rem := s[curr_l : curr_l+word_length]
				curr_cnts[word_to_rem]++
				curr_l += word_length
			}

			if curr_l+substring_size == r+word_length {
				res = append(res, curr_l)
			}
		}
	}

	return res
}

// @lc code=end
