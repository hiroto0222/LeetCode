/*
 * @lc app=leetcode id=1071 lang=golang
 *
 * [1071] Greatest Common Divisor of Strings
 */

// @lc code=start
func gcdOfStrings(str1 string, str2 string) string {
	if str1+str2 != str2+str1 {
		return ""
	}

	k := gcd(len(str1), len(str2))
	return str1[:k]
}

func gcd(a, b int) int {
	for b != 0 {
		a, b = b, a%b
	}

	return a
}

// @lc code=end

