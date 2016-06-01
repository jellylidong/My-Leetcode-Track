public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
    
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        return wordBreak(s, dict, 0, map);
    }
    
    public boolean wordBreak(String s, Set<String> dict, int start, HashMap<Integer, Boolean> map){
        for(int i = start; i <= s.length(); i++){
            if(map.containsKey(i))
                return map.get(i);
            else if (dict.contains(s.substring(start, i))){
                if(i == s.length()){
                    map.put(start, true);
                    return true;
                }
                else{
                    boolean cur = wordBreak(s, dict, i, map);
                    if(cur == true){
                        map.put(start, true);
                        return true;
                    }
                    // else{
                    //     map.put(start, false);
                    // }
                }
            }
        }
        
        map.put(start, false);
        return false;
    }
}