public class Solution {
    public int minCut(String s) {
        if(isP(s))
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < s.length(); i++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            min = Math.min(min, 1+minCut(s1)+minCut(s2));
        }
        return min;
    }
    
    public boolean isP(String s){
        int lo = 0;
        int hi = s.length()-1;
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }
}