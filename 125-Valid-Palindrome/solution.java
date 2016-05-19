public class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length()-1;
        
        while(lo < hi){
            char clo = s.charAt(lo);
            char chi = s.charAt(hi);
            if(clo < 'A' || clo > 'z' ||(clo >'Z' && clo < 'a')){
                clo++;
                continue;
            }
            if(chi < 'A' || chi > 'z' ||(chi >'Z' && chi < 'a')){
                chi--;
                continue;
            }
            
            if(clo != chi)
                return false;
            clo++;
            chi--;
        }
        
        return true;
    }
}