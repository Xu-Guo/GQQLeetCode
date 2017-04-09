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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int newStart = -1;
        int newEnd = -1;
        int p = newInterval.start, q = newInterval.end;
        for (Interval itvl : intervals) {
            if (newStart == -1) {
                if (itvl.end < p) {
                    res.add(new Interval(itvl.start, itvl.end));
                } else if(itvl.start > q) {
                    res.add(newInterval);
                    newStart = p;
                    newEnd = q;
                    res.add(new Interval(itvl.start, itvl.end));
                } else {
                    newStart = itvl.start <= p ? itvl.start : p;
                    if (itvl.end >= q) {
                        newEnd = itvl.end;
                        res.add(new Interval(newStart, newEnd));
                    }
                }
            } else if (newEnd == -1) {
                if (itvl.start > q) {
                    newEnd = q;
                    res.add(new Interval(newStart, newEnd));
                    res.add(new Interval(itvl.start, itvl.end));
                } else if (itvl.end >= q) {
                    newEnd = itvl.end;
                    res.add(new Interval(newStart, newEnd));
                }
            } else {
                res.add(new Interval(itvl.start, itvl.end));
            }
        }
        if (newStart == -1) {
            res.add(new Interval(p, q));
        } else if (newEnd == -1) {
            res.add(new Interval(newStart, Math.max(q, intervals.get(intervals.size() - 1).end)));
        }
        return res;
    }
}