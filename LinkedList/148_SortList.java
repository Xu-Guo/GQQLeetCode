/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }
    
    public ListNode quickSort(ListNode head, ListNode end) {
        if(head == null || head == end) return null;
        ListNode last = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        while(last.next != null && last.next != end) {
            if(last.next.val < head.val) {
                ListNode tmp = pre.next;
                pre.next = last.next;
                last.next = last.next.next;
                pre.next.next = tmp;
            } else {
                last = last.next;
            }
        }
        quickSort(pre.next, head);
        quickSort(head.next, null);
        return pre.next;
    }
}