public class Solution {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        for(int i = 0; i <= num.length()/2; i++){
            char c1 = num.charAt(i);
            char c2 = num.charAt(len-1-i);
            if((c1 == '6' && c2 == '9') ||
               (c1 == '9' && c2 == '6') ||
               (c1 == '8' && c2 == '8') ||
               (c1 == '1' && c2 == '1') ||
               (c1 == '0' && c2 == '0'))
               continue;
            else
                return false;
        }
        
        return true;
    }
}