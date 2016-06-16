public class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[][] count = new int[len+1][len+1];
        for(int i = 0; i <= len; i++){
            for(int j = i; j <= len; j++)
                count[i][j] = -1;
        }
        count[0][0] = 0;
        
        return helper(s, 0, len, count);
    }
    
    public boolean isP(String s, int lo, int hi){
        
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }
    
    public int helper(String s, int lo, int hi, int[][] count){
        if(count[lo][hi] != -1)
            return count[lo][hi];
        // String cur = s.substring(lo, hi);
        if(isP(s, lo, hi-1)){
            count[lo][hi] = 0;
            return 0;
        }
        else{
            int min = Integer.MAX_VALUE;
            for(int i = lo+1; i < hi; i++){
                
                min = Math.min(min, 1 +helper(s, lo, i, count) + helper(s, i, hi, count));
                if(min == 1)
                    break;
            }
            count[lo][hi] = min;
            return min;
        }
    }
}