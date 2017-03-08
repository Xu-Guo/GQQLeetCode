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
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (end - start == 1) {
            return doMerge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode first = merge(lists, start, mid);
        ListNode second = merge(lists, mid + 1, end);
        return doMerge(first, second);
    }

    public ListNode doMerge(ListNode first, ListNode second) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        ListNode f = first, s = second;
        while (f != null && s != null) {
            if (f.val <= s.val) {
                p.next = f;
                f = f.next;
            } else {
                p.next = s;
                s = s.next;
            }
            p = p.next;
        }

        if (f != null) p.next = f;
        if (s != null) p.next = s;
        return head.next;
    }
}

