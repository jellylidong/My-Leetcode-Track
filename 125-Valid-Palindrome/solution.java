public class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length()-1;
        
        while(lo < hi){
            char clo = s.charAt(lo);
            char chi = s.charAt(hi);
            if(!isAN(clo)){
                lo++;
                continue;
            }
            if(!isAN(chi)){
                hi--;
                continue;
            }
            if(clo >= 'A' && clo <= 'Z')
                clo += 32;
            if(chi >= 'A' && chi <= 'Z')
                chi += 32;
            if(clo != chi)
                return false;
            lo++;
            hi--;
        }
        
        return true;
    }
    
    public boolean isAN(char c){
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}