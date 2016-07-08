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
    public int minMeetingRooms(Interval[] its) {
        if(its.length == 0)
            return 0;
        Arrays.sort(its, new comparatorStart());//sort meetings according to its start time
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(its.length, new comparatorEnd());
        pq.offer(its[0]);
        
        for(int i = 1; i < its.length; i++){
            //find the meeting that finishes earliest
            Interval interval = pq.poll();
            if(its[i].start >= interval.end){
                //if current meeting starts after the earliest finished meeting
                //there's no need to add a new room
                //just mere the interval
                interval.end = its[i].end;
            }
            else{
                //otherwise, we need to a new meeting room 
                pq.offer(its[i]);
            }
            //also don't forget to put the previous meeting room back to the pq
            pq.offer(interval);
        }
        
        return pq.size();
    }
    
    public class comparatorStart implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2){
            return i1.start - i2.start;
        }
    }
    public class comparatorEnd implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2){
            return i1.end - i2.end;
        }
    }
}