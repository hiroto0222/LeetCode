/*
 * @lc app=leetcode id=1318 lang=java
 *
 * [1318] Minimum Flips to Make a OR b Equal to c
 */

// @lc code=start
class Solution {
    public int minFlips(int a, int b, int c) {
        /*
         * return min flips of bits in a and b to make a | b == c
         *
         * a -> 0010
         * b -> 0110
         * c -> 0101
         *
         * a | b -> 3 bits
         * 0001
         * 0100
         * 0110
         *
         * abc cnt
         * 000 0
         * 001 1
         * 010 1
         * 011 0
         * 100 1
         * 101 0
         * 110 2
         * 111 0
         *
         * O(N) time, O(1) space
         */

        int res = 0;
        while (a > 0 || b > 0 || c > 0) {
            // if last bit of c is 1
            if (c % 2 == 1) {
                // only case to consider is abc -> 001
                if (a % 2 == 0 && b % 2 == 0) {
                    res++;
                }
            }
            // if last bit of c is 0
            else {
                // case abc -> 110
                if (a % 2 == 1 && b % 2 == 1) {
                    res += 2;
                }
                // case abc -> 100, 010
                else if (a % 2 == 1 || b % 2 == 1) {
                    res++;
                }
            }

            // bit shift right
            a /= 2;
            b /= 2;
            c /= 2;
        }

        return res;
    }
}
// @lc code=end
