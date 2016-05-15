public class Solution {
    public int trailingZeroes(int n) {
        int ans= 0;
        for(int i=0; i <= n; i+=5){
            if(i == 0)
                continue;
            int cur = i;
            while(cur%5 ==0){
                ans++;
                cur /= 5;
            }
        }
        
        return ans;
    }
}