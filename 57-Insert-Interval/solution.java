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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0){
            List<Interval> ans = new ArrayList<>();
            ans.add(newInterval);
            return ans;
        }
        intervals.add(0, new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE));
        intervals.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
        int i = 0;
        for(; i < intervals.size(); i++){
            if(newInterval.start < intervals.get(i).start)
                break;
        }
        
        // if(i == 0){
        //     if(newInterval.start <= intervals.get(0)){
        //         if
        //     }
        // }
        
        // if(i == intervals.size()){
        //     if(newInterval.start == intervals.get(i-1).end){
        //         intervals.get(i-1).end = Math.max(intervals.get(i-1).end, newInterval.end);
        //     }
        //     else
        //         intervals.add(newInterval);
        //     return intervals.subList(0, intervals,size());
        // }
        
        if(newInterval.start <= intervals.get(i-1).end){
            intervals.get(i-1).end = Math.max(newInterval.end, intervals.get(i-1).end);
            i = i-1;
        }
        else{
            intervals.add(i, newInterval);
        }
            
        while(i+1 < intervals.size() && intervals.get(i).end >= intervals.get(i+1).start){
            intervals.get(i).end = Math.max(newInterval.end, intervals.get(i+1).end);
            // intervals.get()
            intervals.remove(i+1);
        }
        
        return intervals.subList(1, intervals.size()-1);
    }
}