/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        int idx = 1;

        while (idx < left) {
            head = head.next;
            groupPrev = groupPrev.next;
            idx++;
        }

        ListNode curr = head;
        ListNode prev = groupPrev;

        while (idx < right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            idx++;
        }

        ListNode next = curr.next;
        curr.next = prev;
        groupPrev.next = curr;
        head.next = next;

        return dummy.next;
    }
}
// @lc code=end
