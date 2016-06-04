public class Solution {
    public int mySqrt(int x) {
        
        if(x <= 0)
            return 0;
            
        //for math problems, we must consider edge values like Integer.MAX_VALUE and Integer.MIN_VALUE
        long lo = 1; 
        long hi = x/2;
        
        while(lo < hi){
            
            long mid = lo + (hi-lo)/2;
            if(mid*mid == x)
                return (int)mid;
            
            //different from traditional binary search, when we change boundary
            //we have to check (mid+1)^2 to make we won't go out of the target range
            else if(mid*mid < x){
                if((mid+1)*(mid+1) > x)
                    return (int)mid;
                else
                    lo = mid+1;
                
            }
            else
                hi = mid-1;
        }
        
        return (int)lo;
    }
}