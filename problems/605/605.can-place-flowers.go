/*
 * @lc app=leetcode id=605 lang=golang
 *
 * [605] Can Place Flowers
 */

package solution

// @lc code=start
import (
	"fmt"
)

func canPlaceFlowers(flowerbed []int, n int) bool {
	if n == 0 {
		return true
	}

	i := 0
	for i < len(flowerbed) {
		if flowerbed[i] == 1 {
			i += 2
			continue
		}

		valid := i == 0 || flowerbed[i-1] == 0
		valid = valid && (i == len(flowerbed)-1 || flowerbed[i+1] == 0)
		fmt.Println(i, valid)

		if valid {
			i += 2
			n -= 1
		} else {
			i += 1
		}

		if n <= 0 {
			return true
		}
	}

	return false
}

// @lc code=end
