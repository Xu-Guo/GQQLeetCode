/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (x,y) -> x.start - y.start);
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>((x, y) -> x.end - y.end);
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval old = queue.poll();
            Interval curr = intervals[i];
            if (curr.start < old.end) {
                // we have to add a meeting room. because old meeting is still on.
                queue.offer(old);
            }
            queue.offer(curr);
        }
        return queue.size();
    }
}