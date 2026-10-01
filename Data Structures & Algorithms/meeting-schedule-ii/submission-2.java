/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
// We use a Min Heap because we want to keep track of the meeting that ends earliest.
// The heap stores the end times of meetings currently occupying rooms.
// For every meeting, if the earliest ending meeting has end <= current.start, that room has become free, so we pop its end time and reuse that room.
// Then we push the current meeting's end time because this meeting now occupies a room.
// At any point, the heap size represents the number of rooms currently occupied. Therefore, the maximum heap size represents the minimum number of rooms required. 

    int n = intervals.size(); 
    Collections.sort(intervals, (a, b) -> a.start - b.start);

    PriorityQueue<Integer> pq = new PriorityQueue<>(); 

    for(Interval interval : intervals){
        if(!pq.isEmpty() && pq.peek() <= interval.start){
            pq.poll();
        }
        pq.add(interval.end);
    } 
    return pq.size();
  }
}
