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
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i=0; i<n; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i = 0, j = 0;
        int max = 0;
        int curr = 0;
        while (i < n && j < n) {
            if (starts[i] < ends[j]) {
                i++;
                max = Math.max(++curr, max);
            } else {
                j++;
                curr--;
            }
        }
        return max;
    }
}