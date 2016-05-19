public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        int num = (int)n;
        for(int i = 0; i < 32; i++){
            ans *= 2;
            ans += num%2;
            num = num >>> 1;;
        }
        
        return (int)ans;
    }
}