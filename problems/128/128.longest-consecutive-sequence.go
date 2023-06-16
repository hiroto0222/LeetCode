/*
 * @lc app=leetcode id=128 lang=golang
 *
 * [128] Longest Consecutive Sequence
 */

package solution

// @lc code=start
func longestConsecutive(nums []int) int {
	// given unsorted nums, return length of longest consecutive elements
	// ie:
	// nums = [100,4,200,1,3,2]
	// -> [1,2,3,4]
	// start from each element, and check increasing sequence
	// at some point we will start from the element that returns the longest
	// if val - 1 exists in the set, then continue -> will always start at lowest
	// O(N) time, O(N) space

	set := make(map[int]bool)
	for _, val := range nums {
		set[val] = true
	}

	res := 0
	for _, val := range nums {
		if set[val-1] {
			continue
		}

		curr := 1
		i := 1
		for set[val+i] {
			curr++
			i++
		}

		res = max(curr, res)
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
