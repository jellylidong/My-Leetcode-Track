public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int min = prices[0];
        int ans = 0;
        
        //!!!
        //update min otherwise update max
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            else
                ans = Math.max(ans, prices[i]-min);
        }
        
        return ans;
    }
}