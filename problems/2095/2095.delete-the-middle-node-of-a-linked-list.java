/*
 * @lc app=leetcode id=2095 lang=java
 *
 * [2095] Delete the Middle Node of a Linked List
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
    public ListNode deleteMiddle(ListNode head) {
        /*
         * delete the middle node
         * middle = Math.floor(n / 2)
         *
         * intuition:
         * - 2 pointers
         * - if size = 1 -> return null
         * - if size = 2 -> head.next = null
         * - else have slow = head, fast = head.next.next
         * - such that fast moves double the speed of slow
         * - when fast reaches the end, slow is 1 node behind middle
         */

        // if linked list is empty
        if (head == null)
            return null;

        // if linked list has 1 node
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next; // move double the speed of slow
        }

        // when while loop ends, slow is 1 node before middle
        slow.next = slow.next.next;

        return head;
    }
}
// @lc code=end
