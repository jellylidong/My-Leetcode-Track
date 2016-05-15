public class Solution {
    public int trailingZeroes(int n) {
        // if(n == 0)
        //     return 1;
        int ans = 0;
        for(int i = 5; n/i >= 1; n = n/5){
            ans += n/i;
        }
        return ans;
    }
}