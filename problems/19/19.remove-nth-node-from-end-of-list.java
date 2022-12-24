/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        for (int i = 0; head != null && i < size - n; i++) {
            prev = head;
            head = head.next;
        }

        prev.next = head.next;

        return dummy.next;
    }

    int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }

        return size;
    }
}
// @lc code=end
