public class Solution {
    public int maxArea(int[] h) {
        int ans = 0;
        for(int i = 0; i < h.length; i++){
            for(int j = i+1; j < h.length; j++){
                ans = Math.max(ans, (j-i)*Math.min(h[i], h[j]));
            }
        }
        
        return ans;
    }
}