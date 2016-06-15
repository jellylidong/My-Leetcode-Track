public class Solution {
    
    //profit[i][j] means the max profit with i transactions until day j
    //note the description, this means it's not necessarily to sell at day j
    //so when i comes to profit[i][j]
    //we have two choices
    //1. we don't make transation at day j, then the profit would be profit[i][j-1]
    //2. we make a transactiona at day j, then the profit would be prices[j]-prices[x] + profit[i-1][x]
    //x can be any day bwteen [0, current j)
    //since prices[j] is instant, so we need to find the max of profit[i-1][x]-prices[x]
    
    public int maxProfit(int[] prices) {
        int K = 2;
        int len = prices.length;
        if(len == 0)
            return 0;
        int[][] profit = new int[K+1][len];
        
        int max = 0;
        for(int k = 1; k <= K; k++){
            int preMax = profit[k-1][0] - prices[0];
            for(int j = 1; j < prices.length; j++){
                //here is a trick, we don't have to go from 0 to j  every time
                //we only need to update preMax by compare preMax with newly generated profit[i][j]-prices[j]
                //if we don't do this, TLE
                profit[k][j] = Math.max(profit[k][j-1], prices[j] + preMax);
                preMax = Math.max(preMax, profit[k-1][j] - prices[j]);
                max = Math.max(max, profit[k][j]);
            }
        }
        
        return max;
    }
    
}