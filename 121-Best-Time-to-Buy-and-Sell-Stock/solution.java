public class Solution {
    public int maxProfit(int[] p) {
        int maxId = -1;
        int minId = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i = 0; i < p.length; i++){
            if(p[i] >= max){
                max = p[i];
                maxId = i;
            }
            if(p[i] <= min){
                min = p[i];
                minId = i;
            }
            if(maxId != -1 && minId != -1 && maxId < minId)
                maxId = minId;
            
            if(maxId != -1 && minId != -1 && maxId > minId){
                ans = Math.max(ans, p[maxId]-p[minId]);
            }
        }
        
        return ans;
    }
}