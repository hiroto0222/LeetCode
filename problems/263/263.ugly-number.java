/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        // ugly is a positive interger with no prime factors other than 2,3,5
        // no prime factors, is also ugly
        // return true if n is ugly
        // 
        // intuition:
        // n = 2^a * 3^b * 5^c
        // so as long as we can keep dividing by 2,3,5, do it until n = 1

        if (n <= 0) return false;
        
        int[] primes = new int[]{2, 3, 5};
        for (int prime : primes) {
            while (n % prime == 0) {
                n /= prime;
            }
        }

        return n == 1;
    }
}
// @lc code=end

