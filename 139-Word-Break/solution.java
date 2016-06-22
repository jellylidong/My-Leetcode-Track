public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String cur = s.substring(j, i);
                res[i] = res[j] && wordDict.contains(cur);
                if(res[i])
                    break;
            }
        }
        
        return res[s.length()];
    }
}