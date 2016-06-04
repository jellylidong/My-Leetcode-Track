public class Solution {
    public int mySqrt(int x) {
        
        if(x <= 0)
            return 0;
        long lo = 1; 
        long hi = x/2;
        
        while(lo < hi){
            
            long mid = lo + (hi-lo)/2;
            if(mid*mid == x)
                return (int)mid;
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