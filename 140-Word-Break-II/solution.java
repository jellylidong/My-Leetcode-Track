public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0)
            return new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
            
        return helper(s, map, wordDict);
    }
    
    
    public List<String> helper(String s, HashMap<String, List<String>> map, Set<String> wordDict){
        if(map.containsKey(s))
            return map.get(s);
            
        List<String> ans = new ArrayList<>();
        if(wordDict.contains(s))
            ans.add(s);
        for(String str: wordDict){
            if(s.startsWith(str)){
                List<String> subAns = helper(s.substring(str.length()), map, wordDict);
                for(String cur: subAns){
                    ans.add(str + " " + cur);
                }
            }
            // if(str.equals(s))
            //     ans.add(str);
        }
        
        map.put(s, ans);
        
        return ans;
    }
}