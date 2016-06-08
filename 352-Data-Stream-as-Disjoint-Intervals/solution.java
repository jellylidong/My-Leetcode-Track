/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.containsKey(val))
            return;
        Integer lo = map.lowerKey(val);
        Integer hi = map.higherKey(val);
        if(lo != null && hi != null && map.get(lo).end + 1 == val && val + 1 ==map.get(hi).start){
            map.get(lo).end = map.get(hi).end;
            map.remove(hi);
        }
        else if(lo != null && map.get(lo).end + 1 >= val){
            map.get(lo).end = Math.max(val, map.get(lo).end);
        }
        // else if(hi != null && map.get(hi).start - 1 <= val){
        //     map.get(hi).start = Math.min(val, map.get(hi).start);
        // }
        else if(hi != null && hi-1 == val){
            map.put(val, new Interval(val, map.get(hi).end));
            map.remove(hi);
        }
        else{
            map.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
    
    
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */