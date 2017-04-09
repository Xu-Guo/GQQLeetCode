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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) return res;
        Collections.sort(intervals, (x, y) -> x.start - y.start);
        res.add(new Interval(intervals.get(0).start, intervals.get(0).end));
        for (int i = 1; i < intervals.size(); i++) {
            Interval last = res.get(res.size() - 1);
            Interval curr = intervals.get(i);
            if (curr.start > last.end) {
                res.add(new Interval(curr.start, curr.end));
            } else {
                if (curr.end > last.end) {
                    last.end = curr.end;
                }
            }
        }
        return res;
    }
}