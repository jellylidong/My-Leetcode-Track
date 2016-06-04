public class Solution {
    public int mySqrt(int x) {
        int lo = 1; 
        int hi = x/2;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(mid*mid == x)
                return mid;
            else if(mid*mid < x)
                lo = (mid+1)*(mid+1) > x? mid: mid+1;
            else
                hi = mid-1;
        }
        
        return lo;
    }
}