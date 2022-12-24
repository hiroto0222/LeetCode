/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null) {
                break;
            }

            ListNode groupNext = kthNode.next;
            ListNode prev = kthNode.next;
            ListNode curr = groupPrev.next;

            while (curr != kthNode) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            curr.next = prev;
            ListNode nextGroupPrev = groupPrev.next;
            groupPrev.next = curr;
            groupPrev = nextGroupPrev;
        }

        return dummy.next;
    }

    ListNode getKthNode(ListNode curr, int cnt) {
        while (curr != null && cnt > 0) {
            curr = curr.next;
            cnt -= 1;
        }
        return curr;
    }
}
// @lc code=end
