public class Solution {
    public void reverseWords(char[] s) {
        //reverse the whole string first
        //then reverse words one by one
        
        reverse(s, 0, s.length-1);
        int i = 0; int j = 0;
        while(i < s.length){
            while(j < s.length && s[j] != ' ')
                j++;
            
            j--;
                
            reverse(s, i, j);
            j += 2;
            i = j;
        }
    }
    
    public void reverse(char[] s, int lo, int hi){
        while(lo < hi){
            char tmp = s[lo];
            s[lo] = s[hi];
            s[hi] = tmp;
            lo++;
            hi--;
        }
    }
}