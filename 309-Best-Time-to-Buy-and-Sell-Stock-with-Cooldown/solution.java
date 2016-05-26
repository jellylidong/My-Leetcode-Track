public class Solution {
    public int maxProfit(int[] p) {
        int len = p.length;
        if(len == 0)
            return 0;
        int[] buy = new int[len];
        int[] rest = new int[len];
        int[] sell = new int[len];
        
        buy[0] = -p[0]; //buy[i] means max profit of day i end with buy
        rest[0] = 0; //
        sell[0] = 0; //
        
        for(int i = 1; i < len; i++){
            buy[i] = Math.max(rest[i-1]-p[i], buy[i-1]);
            rest[i] = Math.max(Math.max(sell[i-1], buy[i-1]), rest[i-1]);
            sell[i] = Math.max(buy[i-1]+p[i], sell[i-1]);
        }
        
        return Math.max(Math.max(buy[len-1], sell[len-1]), rest[len-1]);
    }
}