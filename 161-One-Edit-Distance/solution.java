public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        //used to handle empty string case like s="a", t=""
        s += "*";
        t += "*";
        
        String ls = s;
        String ss = t;
        
        if(s.length() < t.length()){
            ls = t;
            ss = s;
        }
        
        int li = 0, si = 0;
        int count = 0;
        
        while(li < ls.length() && si < ss.length()){
            if(ls.charAt(li) == ss.charAt(si)){
                li++;
                si++;
            }
            else{
                /*
                "abs"
                "bs"
                */
                
                if(ls.length() != ss.length())
                    li++;
                else{
                    li++;
                    si++;
                }
                count++;
            }
        }
        
        return li == ls.length() && count == 1;
    }
}