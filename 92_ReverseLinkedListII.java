/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = dummy;
        for (int i = 1; i < m; i++) last = last.next;
        ListNode pre = last.next;
        ListNode after = pre.next;
        for (int i = 0; i < n - m; i++) {
              ListNode tmp = after.next;
              after.next = last.next;
              last.next = after;
              after = tmp;
        }
        pre.next = after;
        return dummy.next;
    }
}