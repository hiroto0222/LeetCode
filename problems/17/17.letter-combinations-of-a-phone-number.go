/*
 * @lc app=leetcode id=17 lang=golang
 *
 * [17] Letter Combinations of a Phone Number
 */

package solution

// @lc code=start

var phone = map[string][]string{
	"2": []string{"a", "b", "c"},
	"3": []string{"d", "e", "f"},
	"4": []string{"g", "h", "i"},
	"5": []string{"j", "k", "l"},
	"6": []string{"m", "n", "o"},
	"7": []string{"p", "q", "r", "s"},
	"8": []string{"t", "u", "v"},
	"9": []string{"w", "x", "y", "z"},
}

func letterCombinations(digits string) []string {
	// backtrack
	// f(curr_combo, i) -> i is curr digit to add

	res := make([]string, 0)

	if len(digits) == 0 {
		return res
	}

	backtrack("", 0, digits, &res)

	return res
}

func backtrack(curr_combo string, i int, digits string, res *[]string) {
	if i >= len(digits) {
		*res = append(*res, curr_combo)
		return
	}

	for _, c := range phone[string(digits[i])] {
		backtrack(curr_combo+c, i+1, digits, res)
	}
}

// @lc code=end
