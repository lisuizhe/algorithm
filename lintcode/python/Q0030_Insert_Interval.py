"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    """
    @param intervals: Sorted interval list.
    @param newInterval: new interval.
    @return: A new interval list.
    """
    def insert(self, intervals, newInterval):
        # write your code here
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