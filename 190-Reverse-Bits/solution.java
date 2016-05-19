public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long ans = 0;
        long num = (long)n;
        for(int i = 0; i < 32; i++){
            ans *= 2;
            ans += num%2;
            num = num >>> 1;;
        }
        
        return (int)ans;
    }
}