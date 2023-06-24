/*
 * @lc app=leetcode id=198 lang=golang
 *
 * [198] House Robber
 */

package solution

// @lc code=start
func rob(nums []int) int {
	// top down dp
	// start from i = n - 2
	// 2 choices
	// 1. dont rob, then dp[i+1]
	// 2. rob, then dp[i+2] + nums[i]

	n := len(nums)
	dp := make([]int, n+1)
	dp[n-1] = nums[n-1]
	for i := n - 2; i >= 0; i-- {
		dp[i] = max(dp[i+1], dp[i+2]+nums[i])
	}

	return dp[0]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end
