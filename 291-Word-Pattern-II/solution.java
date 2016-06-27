public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> valSet = new HashSet<>();
        return helper(pattern, str, map, valSet);
    }
    
    public boolean helper(String pattern, String str, HashMap<Character, String> map, HashSet<String> valSet){
        if(pattern.length() == 0 && str.length() == 0)
            return true;
            
        if(pattern.length() > str.length())
            return false;
            
        if(pattern.length() == 0 && str.length() != 0)
            return false;
            
        char c = pattern.charAt(0);
        if(map.containsKey(c) && str.startsWith(map.get(c)))
            return helper(pattern.substring(1), str.substring(map.get(c).length()), map, valSet);
        else if(!map.containsKey(c)){
            for(int i = 1; i <= str.length(); i++){
                String sub = str.substring(0, i);
                if(valSet.contains(sub))
                    continue;
                else{
                    map.put(c, sub);
                    valSet.add(sub);
                    boolean res = helper(pattern.substring(1), str.substring(i), map, valSet);
                    if(res == true)
                        return true;
                    else{
                        map.remove(c);
                        valSet.remove(sub);
                    }
                }
            }
        }
        return false;    
    }
}