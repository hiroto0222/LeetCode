/*
 * @lc app=leetcode id=334 lang=golang
 *
 * [334] Increasing Triplet Subsequence
 */

package solution

// @lc code=start
import "math"

func increasingTriplet(nums []int) bool {
	// O(N) time, O(1) space

	first, second := math.MaxInt32, math.MaxInt32
	for _, third := range nums {
		if third > second {
			return true
		}

		if third > first {
			second = third
		} else {
			first = third
		}
	}

	return false
}

// @lc code=end
