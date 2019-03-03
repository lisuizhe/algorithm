# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if not intervals:
            return intervals

        intervals.sort(key=lambda x: (x.start, -x.end))
        result = []
        result.append(intervals[0])
        previous = result[-1]
        for i in range(1, len(intervals)):
            current = intervals[i]
            if current.end <= previous.end:
                continue
            else:
                if current.start <= previous.end:
                    previous.end = current.end
                else:
                    result.append(current)
                    previous = current
        return result

solution = Solution()
inputs = [[1,3],[2,6],[8,10],[15,18]]
intervals = [Interval(s=input[0], e=input[1]) for input in inputs]
print([[result.start, result.end] for result in solution.merge(intervals)])