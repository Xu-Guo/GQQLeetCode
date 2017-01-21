/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode mid = head;
        while(fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        // reverse List after mid
        ListNode curr = mid.next;
        while(curr.next != null) {
            ListNode tmp = mid.next;
            mid.next = curr.next;
            curr.next = mid.next.next;
            mid.next.next = tmp;
        }

        // charge
        ListNode p1 = head;
        ListNode p2 = mid.next;
        while(p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}