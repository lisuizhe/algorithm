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
        result = []
        while i < len(intervals) and intervals[i].end < newInterval.start:
            result.append(intervals[i])
            i += 1
        while i < len(intervals) and intervals[i].start <= newInterval.end:
            newInterval.start = min(intervals[i].start, newInterval.start)
            newInterval.end = max(intervals[i].end, newInterval.end)
            i += 1
        result.append(newInterval)
        while i < len(intervals):
            result.append(intervals[i])
            i += 1
        return result
        