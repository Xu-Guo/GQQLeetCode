/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = tmp;
        }
        return dummy.next;
    }
}