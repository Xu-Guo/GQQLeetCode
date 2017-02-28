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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x,y)->(x.val-y.val));
        for (int i=0; i<lists.length; i++) {
            ListNode p = lists[i];
            while (p != null) {
                ListNode q = new ListNode(p.val);
                queue.add(q);
                p = p.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode q = head;
        while (!queue.isEmpty()) {
            q.next = queue.poll();
            q = q.next;
        }
        return head.next;
    }
}

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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x,y)->(x.val-y.val));
        for (int i=0; i<lists.length; i++) {
            ListNode p = lists[i];
            while (p != null) {
                queue.add(p);
                ListNode q = p;
                p = p.next;
                q.next = null;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode q = head;
        while (!queue.isEmpty()) {
            q.next = queue.poll();
            q = q.next;
        }
        return head.next;
    }
}
