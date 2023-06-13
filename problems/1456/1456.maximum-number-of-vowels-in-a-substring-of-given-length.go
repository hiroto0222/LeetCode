/*
 * @lc app=leetcode id=1456 lang=golang
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 */

package solution

// @lc code=start
func maxVowels(s string, k int) int {
	curr_max := 0
	for i := 0; i < k; i++ {
		if isVowel(s[i]) {
			curr_max++
		}
	}

	curr_cnt := curr_max
	for r := k; r < len(s); r++ {
		if isVowel(s[r-k]) {
			curr_cnt--
		}
		if isVowel(s[r]) {
			curr_cnt++
		}

		curr_max = max(curr_cnt, curr_max)
	}

	return curr_max
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}

func isVowel(c byte) bool {
	s := string(c)
	return s == "a" || s == "e" || s == "i" || s == "o" || s == "u"
}

// @lc code=end
