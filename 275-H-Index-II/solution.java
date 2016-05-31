public class Solution {
    public int hIndex(int[] cs) {
        // for(int i = 0; i < cs.length; i++){
        //     if(cs[i] >= cs.length-i)
        //         return cs.length-i;
        // }
        // return 0;
        
        //above code works O(n)
        //When search a sorted array, or search a local min/max, try to use binary search
        if(cs.length == 0)
            return 0;
        
        int lo = 0;
        int hi = cs.length-1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(cs[mid] < cs.length-mid)
                lo = mid+1;
            else
                hi = mid;
        }
        
        if(cs[lo] >= cs.length - lo)
            return cs.length-lo;
        return 0;
    }
}