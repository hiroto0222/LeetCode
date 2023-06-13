/*
 * @lc app=leetcode id=1431 lang=golang
 *
 * [1431] Kids With the Greatest Number of Candies
 */

package solution

// @lc code=start
func kidsWithCandies(candies []int, extraCandies int) []bool {
	n := len(candies)
	currMax := max(candies)
	res := make([]bool, n)

	for i, val := range candies {
		if val+extraCandies >= currMax {
			res[i] = true
		}
	}

	return res
}

func max(arr []int) int {
	currMax := 0
	for _, val := range arr {
		if val > currMax {
			currMax = val
		}
	}

	return currMax
}

// @lc code=end
