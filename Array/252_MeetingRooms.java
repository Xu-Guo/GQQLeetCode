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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (x,y) -> x.start - y.start);
        // int endtime = intervals[0].end;
        for (int i=1; i<intervals.length; i++) {
            if(intervals[i].start < intervals[i - 1].end) return false;
            // endtime = intervals[i].end;
        }
        return true;
    }
}