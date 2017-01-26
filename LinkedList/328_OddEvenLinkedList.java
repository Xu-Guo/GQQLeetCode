/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dim1 = new ListNode(0);
        ListNode dim2 = new ListNode(0);
        ListNode odd = dim1;
        ListNode even = dim2;
        boolean isOdd = true;
        while(head != null) {
            if (isOdd) {
                odd.next =head;
                odd = odd.next;
                isOdd = false;
            } else {
                even.next = head;
                even = even.next;
                isOdd = true;
            }
            head = head.next;
        }
        // this is very important. If we don't do this, it will form a loop.
        even.next = null;
        odd.next = dim2.next;
        return dim1.next;
    }
}