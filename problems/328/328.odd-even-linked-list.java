/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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
    public ListNode oddEvenList(ListNode head) {
        /*
         * seperate into odd, even nodes
         *
         * intuition:
         * - 2 pointers
         * - rearrange links for odd, even then connect odd.next with evenHead
         *
         * O(N) time, O(1) space
         */

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // rearrange links
        while (even != null && even.next != null) {
            // update odd links
            odd.next = even.next;
            odd = odd.next;

            // update even links
            even.next = odd.next;
            even = even.next;
        }

        // link odd and even
        odd.next = evenHead;

        return head;
    }
}
// @lc code=end
