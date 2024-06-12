/*
 * @lc app=leetcode id=2130 lang=java
 *
 * [2130] Maximum Twin Sum of a Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        /*
         * twin sum is node[i] + node[n - 1 - i] where 0 <= i <= (n / 2) - 1
         * find maximum twin sum
         * n is always even
         *
         * intuition:
         * - find middle point
         * - whilst finding middle point, reverse left side
         *
         * O(N) time, O(1) space
         */

        // find mid point and reverse left side
        ListNode left = head;
        ListNode prev = null;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // reverse
            ListNode next = left.next;
            left.next = prev;
            prev = left;
            left = next;
        }

        // split left and right
        ListNode right = left.next;
        left.next = prev;

        // find max twin sum
        int currMax = 0;
        while (right != null && left != null) {
            if (right.val + left.val > currMax) {
                currMax = right.val + left.val;
            }
            right = right.next;
            left = left.next;
        }

        return currMax;
    }
}
// @lc code=end
