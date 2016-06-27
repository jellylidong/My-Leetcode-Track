public class Solution {
    public void reverseWords(char[] s) {
        int lo = 0;
        int hi = s.length-1;
        while(lo < hi){
            char c = s[lo];
            s[lo] = s[hi];
            s[hi] = c;
            lo++;
            hi--;
        }
        
        lo = 0;
        hi = 0;
        while(hi < s.length){
            if(s[hi] == ' '){
                int curLo = lo;
                int curHi = hi-1;
                while(curLo < curHi){
                    char c = s[curLo];
                    s[curLo] = s[curHi];
                    s[curHi] = c;
                    curLo++;
                    curHi--;
                }
                while(hi < s.length && s[hi] == ' ')
                    hi++;
                lo = hi;
            }
            else
                hi++;
        }
        int curLo = lo;
        int curHi = hi-1;
        while(curLo < curHi){
            char c = s[curLo];
            s[curLo] = s[curHi];
            s[curHi] = c;
            curLo++;
            curHi--;
        }
    }
}