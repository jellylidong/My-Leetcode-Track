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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new myComparator());
        List<Interval> ans = new ArrayList<>();
        if(intervals.size() == 0)
            return ans;
        ans.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            Interval pre = ans.get(ans.size()-1);
            Interval cur = intervals.get(i);
            if(cur.start <= pre.end)
                pre.end = Math.max(pre.end, cur.end);
            else
                ans.add(cur);
        }
        return ans;
    }
    
    public class myComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2){
            return i1.start - i2.start;
        }
    }
}