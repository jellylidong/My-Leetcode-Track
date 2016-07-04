public class Solution {
    public String reverseWords(String s) {
        int lo = 0;
        int hi = 0;
        
        StringBuilder sb = new StringBuilder(s.trim());
        sb.reverse();
        
        while(true){
            while(hi < s.length() && sb.charAt(hi) != ' ')
                hi++;
            int curLo = lo;
            int curHi = hi-1;
            while(curLo < curHi){
                char tmp = sb.charAt(curLo);
                sb.setCharAt(curLo, sb.charAt(curHi));
                sb.setCharAt(curHi, tmp);
                curLo++;
                curHi--;
            }
            
            while(hi < s.length() && sb.charAt(hi) == ' '){
                sb.append(' ');
                hi++;
            }
            lo = hi;
            if(hi == s.length())
                break;
        }
        
        return sb.toString();
        
    }
}