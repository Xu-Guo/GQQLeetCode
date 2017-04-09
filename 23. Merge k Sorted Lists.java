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
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((p, q) -> p.val - q.val);
        for (ListNode ln : lists) {
            if (ln != null)
                pq.offer(ln);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            p.next = curr;
            if (curr.next != null) pq.offer(curr.next);
            p = p.next;
        }
        return dummy.next;
    }
}