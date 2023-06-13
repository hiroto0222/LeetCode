/*
 * @lc app=leetcode id=345 lang=golang
 *
 * [345] Reverse Vowels of a String
 */

package solution

// @lc code=start
import "unicode"

func reverseVowels(s string) string {
	n := len(s)
	l, r := 0, n-1
	str := []rune(s)

	for l < r {
		if !isVowel(str[r]) {
			r--
			continue
		}

		if !isVowel(str[l]) {
			l++
			continue
		}

		str[l], str[r] = str[r], str[l]
		l++
		r--
	}

	return string(str)
}

func isVowel(c rune) bool {
	c = unicode.ToLower(c)
	if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
		return true
	}

	return false
}

// @lc code=end
