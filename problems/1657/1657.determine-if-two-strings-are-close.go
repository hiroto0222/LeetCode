/*
 * @lc app=leetcode id=1657 lang=golang
 *
 * [1657] Determine if Two Strings Are Close
 */

package solution

import "sort"

// @lc code=start
func closeStrings(word1 string, word2 string) bool {
	if len(word1) != len(word2) {
		return false
	}

	c1 := make([]int, 26)
	c2 := make([]int, 26)

	for _, char := range word1 {
		c1[char-'a']++
	}
	for _, char := range word2 {
		c2[char-'a']++
	}

	// check if sets of chars are the same
	for i := 0; i < 26; i++ {
		if (c1[i] > 0 && c2[i] == 0) || (c1[i] == 0 && c2[i] > 0) {
			return false
		}
	}

	// check if frequencies of chars can be matched
	sort.Ints(c1)
	sort.Ints(c2)

	for i := 0; i < 26; i++ {
		if c1[i] != c2[i] {
			return false
		}
	}

	return true
}

// @lc code=end
