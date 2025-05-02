/*
 * @lc app=leetcode id=1952 lang=java
 *
 * [1952] Three Divisors
 */

// @lc code=start
class Solution {
    public boolean isThree(int n) {
        // true if n has exactly three positive divisors
        // iterate sqrt(n)

        int cnt = 0;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                cnt++;
                if (n / i != i) {
                    cnt++;
                }
            }

            if (cnt > 3) {
                return false;
            }
        }

        return cnt == 3;
    }
}
// @lc code=end

