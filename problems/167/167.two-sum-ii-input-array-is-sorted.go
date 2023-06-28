/*
 * @lc app=leetcode id=167 lang=golang
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

package solution

// @lc code=start
func twoSum(numbers []int, target int) []int {
	// 2 pointers l, r
	// if nums[l] + nums[r] > target, r--
	// if nums[l] + nums[r] < target, l--
	// else return

	l, r := 0, len(numbers)-1
	for l < r {
		if numbers[l]+numbers[r] > target {
			r--
		} else if numbers[l]+numbers[r] < target {
			l++
		} else {
			return []int{l + 1, r + 1}
		}
	}

	return []int{-1, -1}
}

// @lc code=end
