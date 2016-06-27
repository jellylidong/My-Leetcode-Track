public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> valSet = new HashSet<>();
        
        return helper(pattern, 0, str.split(" "), 0, map, valSet);
    }
    
    public boolean helper(String pattern, int i, String[] ss, int j, HashMap<Character, String> map, HashSet<String> valSet){
        if(i == pattern.length())
            return j == ss.length;
        if(pattern.length()-i > ss.length-j)
            return false;
            
        if(map.containsKey(pattern.charAt(i)) && map.get(pattern.charAt(i)).equals(ss[j]))
            return helper(pattern, i+1, ss, j+1, map, valSet);
        else if(!map.containsKey(pattern.charAt(i))){
            if(!valSet.contains(ss[j])){
                map.put(pattern.charAt(i), ss[j]);
                valSet.add(ss[j]);
                return helper(pattern, i+1, ss, j+1, map, valSet);
            }
            else
                return false;
        }
        else
            return false;
    }
}