public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        
        //different pattern should not have the same value
        HashSet<String> valSet = new HashSet<>();
        return helper(pattern, str, map, valSet);
    }
    
    public boolean helper(String pattern, String str, HashMap<Character, String> map, HashSet<String> valSet){
        
        //all pattern and str are used up, it means all matches, so return true;
        if(pattern.length() == 0 && str.length() == 0)
            return true;
            
        //one char of pattern should matches at least one char in str
        if(pattern.length() > str.length())
            return false;
            
        //when pattern is used up but str is not, return false
        if(pattern.length() == 0 && str.length() != 0)
            return false;
            
        char c = pattern.charAt(0);
        //if we already have find c's value, and str starts with this value, we can continue with pattern's next char
        if(map.containsKey(c) && str.startsWith(map.get(c)))
            return helper(pattern.substring(1), str.substring(map.get(c).length()), map, valSet);
        //else if we don't find c's value try from str's beginning
        else if(!map.containsKey(c)){
            for(int i = 1; i <= str.length(); i++){
                String sub = str.substring(0, i);
                if(valSet.contains(sub)) // this value is already used, we should not use use value
                    continue;
                else{
                    map.put(c, sub);
                    valSet.add(sub);
                    boolean res = helper(pattern.substring(1), str.substring(i), map, valSet);
                    if(res == true)
                        return true;
                    else{
                        //revocer the map and valSet if current value is invalid
                        map.remove(c);
                        valSet.remove(sub);
                    }
                }
            }
        }
        //if we don't find c's value and we can not find c's value with current pattern and str, return false
        return false;    
    }
}