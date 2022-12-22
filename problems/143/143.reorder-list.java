/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        ListNode left = head;
        ListNode right = getMid(head);

        ListNode temp = right.next;
        right.next = null;
        right = temp;
        right = reverseList(right);

        while (left != null && right != null) {
            ListNode tempLeft = left.next;
            ListNode tempRight = right.next;
            right.next = tempLeft;
            left.next = right;
            left = tempLeft;
            right = tempRight;
        }
    }

    ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            return prev;
        } else {
            return slow;
        }
    }

    ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode curr = head.next;
        ListNode prev = head;
        prev.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
// @lc code=end
