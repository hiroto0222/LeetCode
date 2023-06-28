/*
 * @lc app=leetcode id=36 lang=golang
 *
 * [36] Valid Sudoku
 */

package solution

import "strconv"

// @lc code=start
func isValidSudoku(board [][]byte) bool {
	// check rows
	for i := 0; i < 9; i++ {
		curr := make([]bool, 9)
		for j := 0; j < 9; j++ {
			if string(board[i][j]) == "." {
				continue
			}
			num, _ := strconv.Atoi(string(board[i][j]))
			if !curr[num-1] {
				curr[num-1] = true
			} else {
				return false
			}
		}
	}

	// check cols
	for j := 0; j < 9; j++ {
		curr := make([]bool, 9)
		for i := 0; i < 9; i++ {
			if string(board[i][j]) == "." {
				continue
			}
			num, _ := strconv.Atoi(string(board[i][j]))
			if !curr[num-1] {
				curr[num-1] = true
			} else {
				return false
			}
		}
	}

	// check 3x3
	for i := 0; i < 9; i += 3 {
		for j := 0; j < 9; j += 3 {
			curr := make([]bool, 9)
			for ii := i; ii < i+3; ii++ {
				for jj := j; jj < j+3; jj++ {
					if string(board[ii][jj]) == "." {
						continue
					}
					num, _ := strconv.Atoi(string(board[ii][jj]))
					if !curr[num-1] {
						curr[num-1] = true
					} else {
						return false
					}
				}
			}
		}
	}

	return true
}

// @lc code=end
