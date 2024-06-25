/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        /*
         * return list of suggested products after each character of searchWord is typed
         * suggestions are at most 3 products where:
         * - product has common prefix with searchWord
         * - if more than 3 products, return the three lexicographically minimum
         * products
         *
         * intuition:
         * - 2 pointers, closing window
         * - sort products in ascending order
         * - for each character, keep incrementing/decrementing the 2 pointers until all
         * products match the prefix
         * - output the first 3 products from the left pointer
         *
         * O(NlogN + (M + N)) time, O(logN) space for sorting
         */

        int n = products.length;
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int l = 0, r = n - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> curr = new ArrayList<>();
            char c = searchWord.charAt(i);

            while (l <= r && (products[l].length() <= i || products[l].charAt(i) < c)) {
                l++;
            }
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) > c)) {
                r--;
            }

            if (l <= r) {
                for (int j = l; j <= l + 2 && j <= r; j++) {
                    curr.add(products[j]);
                }
            }

            res.add(curr);
        }

        return res;
    }
}
// @lc code=end
