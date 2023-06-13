/*
 * @lc app=leetcode id=151 lang=golang
 *
 * [151] Reverse Words in a String
 */

package solution

import "strings"

// @lc code=start
func reverseWords(s string) string {
	str := strings.Fields(s)
	for i := 0; i < len(str)/2; i++ {
		str[i], str[len(str)-1-i] = str[len(str)-1-i], str[i]
	}

	return strings.Join(str, " ")
}

// @lc code=end
