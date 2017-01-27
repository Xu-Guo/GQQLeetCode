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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        quickSort(pre, null);
        return pre.next;
    }
    
    public void quickSort(ListNode pre, ListNode end) {
        if (pre == null || pre.next == null || pre.next == end) {
            return;
        }
        ListNode pivot = pre.next;
        ListNode last = pivot;
        while(last !=null && last.next != null && last.next != end) {
            if(last.next.val < pivot.val) {
                ListNode tmp = pre.next;
                pre.next = last.next;
                last.next = last.next.next;
                pre.next.next = tmp;
            } else {
                last = last.next;
            }
        }
        // ListNode p = pre.next;
        // while(p != null) {
        //     System.out.print(p.val +" ");
        //     p = p.next;
        // }
        // System.out.println();
        quickSort(pre, pivot);
        quickSort(pivot, null);
    }
}