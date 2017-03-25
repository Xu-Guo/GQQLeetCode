/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        while (q != null && q.next != null) {
            p.next = q.next;
            q.next = p.next.next;
            p.next.next = q;
            p = q;
            q = q.next;
        }
        return dummy.next;
    }
}