public class Solution {
    // HashMap<Integer, Integer> map;
    int[] mem;
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0)
            return 0;
        
        Arrays.sort(coins);
        // map = new HashMap<>(); // key is amunt, val is the min ways
        mem = new int[amount];
        return helper(coins, amount);
    }
    
    public int helper(int[] coins, int amount){
        if(amount < 0)
            return -1;
        if(amount == 0)
            return 0;
        // if(map.containsKey(amount))
        //     return map.get(amount);
        if(mem[amount-1] != 0)
            return mem[amount-1];
            
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(amount-coins[i] < 0)
                break;
            int cur = helper(coins, amount-coins[i]);
            if(cur >= 0)
                ans = Math.min(ans, 1+cur);

        }
        ans = ans == Integer.MAX_VALUE? -1: ans;
        // map.put(amount, ans);
        mem[amount-1] = ans;
        return ans;
    }
}