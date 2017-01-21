/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode fp = new ListNode(0);
        ListNode fq = new ListNode(0);
        fp.next = head;
        fq.next = head;
        ListNode p = fp;
        ListNode q = fq
        while(q.next != null) {
            if (q.next.val < x) {
                p.next = q.next;
                q.next = p.next.next;
                p = p.next;
            } else {
                q = q.next;
            }
        }
        p.next = fq.next;
        return fp.next;
    }
}