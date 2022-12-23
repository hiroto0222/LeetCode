import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> seen = new HashMap<>();
        ListNode dummy = new ListNode(0, head);

        // hashmap[prefix_sum] = currNode
        ListNode currNode = dummy;
        int currSum = 0;
        while (currNode != null) {
            currSum += currNode.val;
            if (seen.containsKey(currSum)) {
                // remove entries from hashmap
                ListNode toRemove = seen.get(currSum).next;
                int removeSum = currSum;
                while (toRemove != currNode) {
                    removeSum += toRemove.val;
                    seen.remove(removeSum);
                    toRemove = toRemove.next;
                }

                seen.get(currSum).next = currNode.next;
            } else {
                seen.put(currSum, currNode);
            }
            currNode = currNode.next;
        }

        return dummy.next;
    }
}
// @lc code=end
