public class Solution {
    // public int maxProfit(int[] prices) {
    //     int K = 2;
    //     int len = prices.length;
    //     int[][] profit = new int[K+1][len];
    //     //profit[i][j] means the max profit after jkth transaction and day j
        
    //     int max = 0;
    //     for(int i = 1; i <= K; i++){
            
    //         for(int j = 1; j < prices.length; j++){
                
    //             for(int m = 0; m < j; m++)
    //                 preMax = Math.max(preMax, prices[j]-prices[m] + profit[i-1][m]);
    //             profit[i][j] = Math.max(profit[i][j-1], preMax);
    //             max = Math.max(max, profit[i][j]);
    //         }
    //     }
        
    //     return max;
    // }
    
    public int maxProfit(int[] prices) {
        int K = 2;
        int len = prices.length;
        int[][] profit = new int[K+1][len];
        //profit[i][j] means the max profit after jkth transaction and day j
        
        int max = 0;
        for(int i = 1; i <= K; i++){
            int preMax = profit[i][0] - prices[0];
            for(int j = 1; j < prices.length; j++){
                
               
                    // preMax = Math.max(preMax, prices[j]-prices[m] + profit[i-1][m]);
                profit[i][j] = Math.max(profit[i][j-1], prices[j] + preMax);
                preMax = Math.max(preMax, profit[i][j] - prices[j]);
                max = Math.max(max, profit[i][j]);
            }
        }
        
        return max;
    }
}