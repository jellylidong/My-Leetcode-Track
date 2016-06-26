public class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        
        int lo = 0;
        int hi = s.length()-1;
        
        while(lo < hi){
            while(lo < hi && !isAlphanumeric(s.charAt(lo)))
                lo++;
            while(hi > lo && !isAlphanumeric(s.charAt(hi)))
                hi--;
            if(s.charAt(lo) != s.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        
        return true;
    }
    
    public boolean isAlphanumeric(char c){
        return (c >= '0' && c <= '9') || 
               (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z');
    }
}