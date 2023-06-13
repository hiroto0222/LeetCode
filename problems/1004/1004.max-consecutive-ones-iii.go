/*
 * @lc app=leetcode id=1004 lang=golang
 *
 * [1004] Max Consecutive Ones III
 */

package solution

// @lc code=start
func longestOnes(nums []int, k int) int {
	l, r, curr, res := 0, 0, 0, 0

	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			curr++
		}

		for curr > k {
			if nums[l] == 0 {
				curr--
			}
			l++
		}

		r++
		res = max(res, r-l)
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}

// @lc code=end
