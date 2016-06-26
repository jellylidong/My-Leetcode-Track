public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        s += "*";
        t += "*";
        //for cases like one is empty, the other is length 1,
        //like: "a", ""
        
        String ls = s;
        String ss = t;
        
        if(s.length() < t.length()){
            ls = t;
            ss = s;
        }
        
        int li = 0, si = 0;
        int diffCount = 0;
        
        while(li < ls.length() && si < ss.length()){
            if(ls.charAt(li) == ss.charAt(si)){
                li++;
                si++;
            }
            else{
                if(ls.length() != ss.length())
                    li++;
                else{
                    li++;
                    si++;
                }
                diffCount++;
            }
        }
        
        return diffCount == 1 && li == ls.length();
    }
}