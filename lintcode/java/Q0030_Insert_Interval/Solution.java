package Q0030_Insert_Interval;

import java.util.ArrayList;
import java.util.List;


// Definition of Interval: 
class Interval { 
    int start, end; 
    Interval(int start, int end) { this.start = start; this.end = end; } 
}

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        int i = 0;
        List<Interval> result = new ArrayList<>();
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }
}