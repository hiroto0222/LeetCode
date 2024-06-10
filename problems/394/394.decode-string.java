/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        /*
         * intuition:
         * - stack for numbers, strings
         * - numbers are in the range [1, 300]
         * so must make sure conversion of "123" -> 123
         * - can have nested encoding such as "3[a2[c]]"
         *
         * O(N) time, O(N) space
         */

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder currSb = new StringBuilder();
        int n = 0;

        for (char c : s.toCharArray()) {
            // if character is a digit, add to current n
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            }
            // if character is '[', push curr n to numStack and reset
            // also push currSb to sbStack and reset
            else if (c == '[') {
                numStack.push(n);
                n = 0;
                sbStack.push(currSb);
                currSb = new StringBuilder();
            }
            // if character is ']', pop num stack to obtain curr k
            // pop sbStack to obtain curr sb
            else if (c == ']') {
                int k = numStack.pop();
                StringBuilder temp = currSb;
                currSb = sbStack.pop();

                while (k-- > 0) {
                    currSb.append(temp);
                }
            }
            // else c is an english character so append to currSb
            else {
                currSb.append(c);
            }
        }

        return currSb.toString();
    }
}
// @lc code=end
