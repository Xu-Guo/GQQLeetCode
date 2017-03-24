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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = head;
        boolean needReverse = true;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                needReverse = false;
                break;
            }
            tail = tail.next;
        }
        while (needReverse) {
            ListNode p = pre.next;
            ListNode q = p.next;
            while (q != tail) {
                p.next = q.next;
                q.next = pre.next;
                pre.next = q;
                q = p.next;
            }

            pre = p;
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    needReverse = false;
                    break;
                }
                tail = tail.next;
            }
        }
        return dummy.next;
    }
}