/*
 * @lc app=leetcode id=643 lang=golang
 *
 * [643] Maximum Average Subarray I
 */

package solution

import "math"

// @lc code=start

func findMaxAverage(nums []int, k int) float64 {
	curr_sum := 0
	for i := 0; i < k; i++ {
		curr_sum += nums[i]
	}
	curr_max := float64(curr_sum) / float64(k)

	for r := k; r < len(nums); r++ {
		curr_sum -= nums[r-k]
		curr_sum += nums[r]

		curr_max = math.Max(curr_max, float64(curr_sum)/float64(k))
	}

	return curr_max
}

// @lc code=end
