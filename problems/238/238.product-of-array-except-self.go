/*
 * @lc app=leetcode id=238 lang=golang
 *
 * [238] Product of Array Except Self
 */

package solution

// @lc code=start
func productExceptSelf(nums []int) []int {
	n, res, suff := len(nums), make([]int, len(nums)), 1
	res[0] = 1
	for i := 1; i < n; i++ {
		res[i] = res[i-1] * nums[i-1]
	}
	for i := n - 1; i >= 0; i-- {
		res[i] *= suff
		suff *= nums[i]
	}

	return res
}

// @lc code=end
