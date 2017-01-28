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
        if(intervals.size() == 0) return intervals;
        Comparator<Interval> interCompare = (i1, i2) -> i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end;
        Collections.sort(intervals, interCompare);
        List<Interval> results = new ArrayList<Interval>();
        Interval tmp = null;
        for(Interval inter : intervals) {
            if(tmp == null) {
                tmp = new Interval(inter.start, inter.end);
            } else {
                if(tmp.end >= inter.start) {
                    tmp.end = Math.max(tmp.end, inter.end);
                } else {
                    results.add(tmp);
                    tmp = new Interval(inter.start, inter.end);
                }
            }
        }
        results.add(tmp);
        return results;
    }
}
