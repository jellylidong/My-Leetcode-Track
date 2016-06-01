public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] res = new boolean[len+1];
        //res[i] is true if s.substring(0, i) is breakable
        res[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                res[i] = res[j] && dict.contains(s.substring(j, i));
                if(res[i])
                    break;
            }
        }
        
        return res[len];
        
        
    }
    
    
}