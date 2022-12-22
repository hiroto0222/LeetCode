/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;

        while (curr.next != null) {
            if (curr.next.val < curr.val) {
                ListNode start = dummy;
                ListNode toSwap = curr.next;
                curr.next = curr.next.next;

                while (start.next.val < toSwap.val) {
                    start = start.next;
                }

                toSwap.next = start.next;
                start.next = toSwap;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
// @lc code=end
