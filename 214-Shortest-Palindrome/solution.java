public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        
        int i = s.length()-1;
        
        StringBuilder sb = new StringBuilder(s);
        while(i >= 0 && !isP(sb)){
            StringBuilder head = new StringBuilder(s.substring(i)).reverse();
            sb = head.append(s);
            i--;
        }
        
        return sb.toString();
    }
    
    public boolean isP(StringBuilder sb){
        int lo = 0;
        int hi = sb.length()-1;
        while(lo < hi){
            if(sb.charAt(lo) != sb.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        
        return true;
    }
}