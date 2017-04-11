/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKListsDtl(lists, 0, lists.length - 1);
    }

    public ListNode mergeKListsDtl(ListNode[] lists, int st, int ed) {
        if (st > ed) return null;
        if (ed - st == 0) return lists[st];
        int mid = st + (ed - st) / 2;
        ListNode left = mergeKListsDtl(lists, st, mid); 
        ListNode right = mergeKListsDtl(lists, mid + 1, ed);
        return doMergh(left, right);
        // return null;
    }

    public ListNode doMergh(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                p = p.next;
                left = left.next;
            } else {
                p.next = right;
                p = p.next;
                right = right.next;
            }
        }
        if (left != null) p.next = left;
        if (right != null) p.next = right;
        return dummy.next;
    }
}