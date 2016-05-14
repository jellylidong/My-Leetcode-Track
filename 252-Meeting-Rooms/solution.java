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
    
    
    public class myComp implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2){
            return i1.start-i2.start;
        }
    }
    
    public boolean canAttendMeetings(Interval[] intervals) {
        
        
    
        Arrays.sort(intervals, new myComp());
        for(int i = 0; i < intervals.length-1; i++){
            if(intervals[i].end > intervals[i+1].start)
                return false;
        }
        return true;
    }
    
    
}