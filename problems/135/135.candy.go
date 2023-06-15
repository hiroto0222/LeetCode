/*
 * @lc app=leetcode id=135 lang=golang
 *
 * [135] Candy
 */

package solution

// @lc code=start
func candy(ratings []int) int {
	// O(N) time, O(N) space
	// ratings = [0,1,2,4,3,2,1,0]
	// l -> r  = [1,2,3,4,1,1,1,1]
	// r -> l  = [1,2,3,5,4,3,2,1]

	n := len(ratings)
	candies := make([]int, n)

	// init 1 candy for all children
	for i := 0; i < n; i++ {
		candies[i] = 1
	}

	// left -> right
	for i := 1; i < n; i++ {
		if ratings[i] > ratings[i-1] {
			candies[i] = candies[i-1] + 1
		}
	}

	// right -> left
	for i := n - 2; i >= 0; i-- {
		if ratings[i] > ratings[i+1] && candies[i] <= candies[i+1] {
			candies[i] = candies[i+1] + 1
		}
	}

	res := 0
	for _, val := range candies {
		res += val
	}

	return res
}

// @lc code=end
