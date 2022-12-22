/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = head;

        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            prev.next = head.next;
            prev = head.next;
            head = head.next;
        }

        return dummy.next;
    }
}
// @lc code=end
