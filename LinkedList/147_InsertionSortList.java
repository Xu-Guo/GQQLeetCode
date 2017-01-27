/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        while(last.next != null) {
            ListNode curr = last.next;
            ListNode p = dummy;
            while(p !=null && p.next != null) {
                if(p == last) {
                    last = curr;
                    break;
                }
                if(p.next.val > curr.val) {
                    last.next = curr.next;
                    curr.next = p.next;
                    p.next = curr;
                    break;
                }
                p = p.next;
            }
        }
        return dummy.next;
    }
}