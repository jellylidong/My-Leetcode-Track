public class Solution {
    public int divide(int dd, int dr) {
        if(dr == 0)
            return Integer.MAX_VALUE;
        if(dd == Integer.MIN_VALUE && dr == -1)
            return Integer.MAX_VALUE;
        
        int sign = 1;
        if((dd > 0 && dr < 0) || (dd < 0 && dr > 0))
            sign = -1;
        
        long ldd = Math.abs((long) dd);
        long ldr = Math.abs((long) dr);
        
        int ans = 0;
        
        //note it should be >=
        while(ldd >= ldr){
            int count = 0;
            long curldr = ldr;
            while(ldd >= curldr){
                count++;
                curldr = curldr << 1;
            }
            
            ans += (1 << (count-1));
            ldd -= (curldr >> 1);
        }
     
        return sign==1? ans: -ans;   
    }
}