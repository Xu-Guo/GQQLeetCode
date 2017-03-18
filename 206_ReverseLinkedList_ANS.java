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
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

     public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        ListNode sub = reverseList(p);
        // 1 -> 2 -> 3, sub 3 -> 2, p.next = head
        p.next = head;
        head.next = null;
        return sub;
    }
}