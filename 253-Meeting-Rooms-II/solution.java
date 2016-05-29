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
        int n = its.length;
        int[] ss = new int[n];
        int[] ee = new int[n];
        for(int i = 0; i < n; i++){
            ss[i] = its[i].start;
            ee[i] = its[i].end;
        }
        
        Arrays.sort(ss);
        Arrays.sort(ee);
        
        int si = 0;
        int ei = 0;
        int count = 0;
        int ans = 0;
        while(si < n ){
            
            if(ss[si] < ee[ei]){
                count++;
                si++;
            }
            else{
                count--;
                ei++;
            }
                
            ans = Math.max(ans, count);
            // else{
            //     count--;
            //     ei++;
            // }
        }
        
        return ans;
    }
}