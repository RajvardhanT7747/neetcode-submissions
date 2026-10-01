class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        int n = intervals.size();

        // Sort the intervals by start time
        Collections.sort(intervals,
            (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < n; i++) {

            Interval prev = intervals.get(i - 1);
            Interval current = intervals.get(i);

            if (current.start < prev.end) {
                return false;
            }
        }
        return true;
    }
}