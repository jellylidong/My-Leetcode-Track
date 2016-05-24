public class Solution {
    public int maxProfit(int[] p) {
        int ans = 0;
        for(int i = 1; i < p.length; i++){
            if(p[i] > p[i-1])
                ans += p[i]-p[i-1];
        }
        
        return ans;
    }
}