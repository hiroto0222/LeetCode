/*
 * @lc app=leetcode id=80 lang=golang
 *
 * [80] Remove Duplicates from Sorted Array II
 */

package solution

// @lc code=start
func removeDuplicates(nums []int) int {
	// O(N) time, O(1) space

	k := 0
	for _, val := range nums {
		if k < 2 || val > nums[k-2] {
			nums[k] = val
			k++
		}
	}

	return k
}

// @lc code=end
