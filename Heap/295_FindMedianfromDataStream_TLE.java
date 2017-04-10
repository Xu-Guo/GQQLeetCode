public class MedianFinder {
    Dupnode head;
    Dupnode tail;
    int count;
    Dupnode p;
    /** initialize your data structure here. */
    public MedianFinder() {
        head = new Dupnode(Integer.MIN_VALUE);
        tail = new Dupnode(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        p = head;
        count = 0;
    }
    
    public void addNum(int num) {
        Dupnode node = new Dupnode(num);
        Dupnode q = p;
        if (p.val <= num) {
            while (q.next.val < num) q = q.next;
            // insert num to q.next;
            node.next = q.next;
            q.next = node;
            node.next.pre = node;
            node.pre = q;
            if (count % 2 == 0) p = p.next;
        } else {
            while (q.val > num) q = q.pre;
            node.next = q.next;
            q.next = node;
            node.next.pre = node;
            node.pre = q;
            if (count % 2 == 1) p = p.pre;
        }
        count++;
    }
    
    public double findMedian() {
        if (count % 2 == 1) {
            return p.val;
        } else {
            return (double)(p.val + p.next.val) / 2;
        }

    }
}

class Dupnode {
    Dupnode pre;
    Dupnode next;
    int val;
    public Dupnode(int value) {
        val = value;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */