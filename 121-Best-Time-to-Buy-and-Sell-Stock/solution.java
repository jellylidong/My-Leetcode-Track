public class Solution {
    public int maxProfit(int[] p) {
        if(p.length == 0)
            return 0;
        int min = p[0];
        int ans = 0;
        
        for(int i = 0; i < p.length; i++){
            if(p[i] < min){
                min = p[i];
            }
            else{
                ans = Math.max(ans, p[i]-min);
            }
        }
        
        return ans;
    }
}