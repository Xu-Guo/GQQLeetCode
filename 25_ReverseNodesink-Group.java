/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode pre = head, after = pre.next;
        for (int i = 1; i < k; i++) {
            
        }
    }
}