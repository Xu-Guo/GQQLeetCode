/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, Integer> first = new HashMap<>();
        Map<Integer, RandomListNode> sencond = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        first.put(head, 0);
        sencond.put(0, newHead);
        RandomListNode p = head;
        RandomListNode q = newHead;
        int cnt = 1;
        while(p.next != null) {
            p = p.next;
            first.put(p, cnt);
            q.next = new RandomListNode(p.label);
            q = q.next;
            sencond.put(cnt, q);
            cnt++;
        }

        p = head;
        q = newHead;
        while(p != null) {
            RandomListNode r = p.random;
            if(r != null) {
                int index = first.get(r);
                RandomListNode r2 = sencond.get(index);
                q.random = r2;
            }
            p = p.next;
            q = q.next;
        }

        return newHead;
    }
}