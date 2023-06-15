/*
 * @lc app=leetcode id=76 lang=golang
 *
 * [76] Minimum Window Substring
 */

package solution

import "math"

// @lc code=start
func minWindow(s string, t string) string {
	m := len(s)
	n := len(t)

	if m == 0 || n == 0 || m < n {
		return ""
	}

	dict := make(map[byte]int)
	for i := 0; i < n; i++ {
		dict[t[i]]++
	}

	required := len(dict)
	actual := 0
	window := make(map[byte]int)
	res := math.MaxInt64
	res_l, res_r := 0, 0
	l := 0

	for r := 0; r < m; r++ {
		curr_char := s[r]
		window[curr_char]++

		if cnt, ok := dict[curr_char]; ok && window[curr_char] == cnt {
			actual++
		}

		for l <= r && actual == required {
			curr_size := r - l + 1
			if curr_size < res {
				res = curr_size
				res_l, res_r = l, r
			}

			left_char := s[l]
			window[left_char]--

			if cnt, ok := dict[left_char]; ok && window[left_char] < cnt {
				actual--
			}

			l++
		}
	}

	if res == math.MaxInt64 {
		return ""
	}

	return s[res_l : res_r+1]
}

// @lc code=end
