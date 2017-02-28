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
        int k = lists.length;
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode p = head;

        while(true) {
            ListNode selectedNode = head;
            int minIndex = -1;
            for (int i=0; i<k; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < selectedNode.val) {
                        selectedNode = lists[i];
                        minIndex = i;
                    }
                }
            }
            if (selectedNode == head) break;
            p.next = selectedNode;
            p = selectedNode;
            lists[minIndex] = lists[minIndex].next;
        }
        return head.next;
    }
}