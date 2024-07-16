import java.util.Stack;

class Solution {
    public int minLength(String s) {
        /*
         * return minimum possible length of S after
         * remove "AB" or "CD" number of operations.
         *
         * intuition:
         * - use stack to keep track of possible AB, CD
         *
         * O(N) time, O(N) space.
         */

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && c == 'B') || (stack.peek() == 'C' && c == 'D'))) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.size();
    }
}
