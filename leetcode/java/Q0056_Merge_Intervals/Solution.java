package Q0056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        intervals.sort(new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o2.end - o1.end;
                }
            }

        });

        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        Interval previous = result.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.end <= previous.end) {
                continue;
            } else {
                if (current.start<= previous.end) {
                    previous.end = current.end;
                } else {
                    result.add(current);
                    previous = current;
                }
            }
        }
        return result;
    }
}