public class Solution {
    public int numSquares(int n) {
        if(n <= 3)
            return n;
            
        int min = Integer.MAX_VALUE;    
        for(int i = 1; i*i <= n; i++){
            min = Math.min(min, numSquares(n-i*i));
        }
        
        return 1 + min;
    }
}