# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        i = 0
        res = []
        n = len(intervals)
        intr = newInterval
        while i < n and intervals[i].end < newInterval.start:
            res.append(intervals[i])
            i += 1

        while i < n and intervals[i].start <= newInterval.end:
            intr = Interval(min(intervals[i].start, intr.start), max(intervals[i].end, intr.end))
            i += 1
        res.append(intr)

        while i < n:
            res.append(intervals[i]);
            i += 1

        return res
