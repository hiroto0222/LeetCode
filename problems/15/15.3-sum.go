/*
 * @lc app=leetcode id=15 lang=golang
 *
 * [15] 3Sum
 */

package solution

import "sort"

// @lc code=start
func threeSum(nums []int) [][]int {
	// return all the triplets [nums[i], nums[j], nums[k]] such that
	// i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
	// ie:
	// nums = [-1,0,1,2,-1,-4]
	// -> [[-1,0,1], [-1,2,-1]]
	//
	// approach:
	// 1. sort nums (order doesnt matter)
	// -> [-4,-1,-1,0,1,2]
	// 2. iterate nums[i]
	// 3. for each nums[i] use 2 pointers j = i + 1 and k = n - 1
	// 4. if sum < 0, j++
	// 5. if sum > 0, k--
	// 6. if sum = 0, j++ till no longer nums[j]

	n := len(nums)
	res := make([][]int, 0)
	sort.Ints(nums)

	for i := 0; i < n; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		j, k := i+1, n-1
		for j < k {
			curr_sum := nums[i] + nums[j] + nums[k]
			if curr_sum < 0 {
				j++
			} else if curr_sum > 0 {
				k--
			} else {
				res = append(res, []int{nums[i], nums[j], nums[k]})
				j++
				for j < k && nums[j] == nums[j-1] {
					j++
				}
			}
		}
	}

	return res
}

// @lc code=end
