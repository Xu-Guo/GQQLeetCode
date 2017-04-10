public class MedianFinder {
    PriorityQueue<Integer> bigHead;
    PriorityQueue<Integer> smallHead;
    /** initialize your data structure here. */
    public MedianFinder() {
        bigHead = new PriorityQueue<Integer>((x, y) -> y - x);
        smallHead = new PriorityQueue<Integer>((x, y) -> x - y);
    }
    
    public void addNum(int num) {
        if (bigHead.size() == 0 || num <= bigHead.peek()) {
            bigHead.offer(num);
        } else {
            smallHead.offer(num);
        }
        if (Math.abs(bigHead.size() - smallHead.size()) >= 2) {
            if (bigHead.size() > smallHead.size()) {
                smallHead.offer(bigHead.poll());
            } else {
                bigHead.offer(smallHead.poll());
            }
        }
    }
    
    public double findMedian() {
        int size1 = bigHead.size();
        int size2 = smallHead.size();
        if (size1 == size2) {
            return (double)(bigHead.peek() + smallHead.peek()) / 2;
        }
        return size1 > size2 ? bigHead.peek() : smallHead.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */