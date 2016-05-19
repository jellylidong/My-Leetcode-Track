public class Solution {
    public int reverse(int x) {
        long xx = Math.abs((long)x);
        long ans = 0;
        while(xx != 0){
            ans *= 10;
            ans += xx%10;
            xx = xx /10;
        }
        
        if(ans > Integer.MAX_VALUE)
            return 0;
        return x>0? (int)ans: -(int)ans;
    }
}