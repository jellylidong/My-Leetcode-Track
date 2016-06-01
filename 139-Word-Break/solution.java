public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
    
        
        for(int i = 0; i <= s.length(); i++){
            System.out.println(s.substring(0, i));
            if(dict.contains(s.substring(0, i))){
                if(i == s.length())
                    return true;
                boolean cur = wordBreak(s.substring(i), dict);
                if(cur)
                    return true;
            }
        }
        
        return false;
    }
}