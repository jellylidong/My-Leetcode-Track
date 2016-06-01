public class Solution {
    
    /*
    Thought: compared to other sumbissions (which is wrong somehow but the method should be correct, but can't find why)
    In this method, instead of using dfs to find the deeper result and then compute the shallower one with the deeper one
    We compute from shallow to deep
    This is exactly DP
    So when DFS is complex to implement
    Consider forward DP (from shallow to deep)
    */
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