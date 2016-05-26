public class Solution {
    public int maxProfit(int k, int[] p) {
        int len = p.length;
        if(len == 0)
            return 0;
        if(k >= len/2){
            int ans = 0;
            for(int i = 1; i < len; i++)
                ans += p[i]-p[i-1]>0? p[i]-p[i-1]: 0;
                
            return ans;
        }
            
        int[][] ans = new int[k+1][len]; //ans[i][j] is max profit of up to i times transactiona and up to day j, both inclusive
        
        for(int i = 1; i <= k; i++){
            int maxProfAfterBuy = -p[0];
            for(int j = 1; j < len; j++){
                ans[i][j] = Math.max(ans[i][j-1], maxProfAfterBuy+p[j]);
                maxProfAfterBuy = Math.max(maxProfAfterBuy, ans[i-1][j-1] - p[j]);
            }
        }
        
        return ans[k][len-1];
    }
}