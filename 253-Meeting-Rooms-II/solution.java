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
        Arrays.sort(its, new comparatorStart());
        PriorityQueue<Interval> pq = new PriorityQueue<>(its.length, new comparatorEnd());
        int count = 0;
        pq.offer(its[0]);
        
        for(int i = 1; i < its.length; i++){
            Interval interval = pq.poll();
            if(its[i].start >= interval.end){
                interval.end = its[i].end;
            }
            else{
                pq.offer(its[i]);
            }
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