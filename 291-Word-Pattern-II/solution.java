public class Solution {
    HashMap<String, String> map;
    public boolean wordPatternMatch(String pattern, String str) {
        map = new HashMap<>();
        map.put("", "");
        return match(pattern, str);
    }
    
    public boolean match(String p, String s){
        if(map.containsKey(p) && map.get(p).equals(s))
            return true;
        for(int i = 1; i <= p.length(); i++){
            String ps = p.substring(0, i);
            if(map.containsKey(ps) && s.startsWith(map.get(ps))){
                boolean res = match(p.substring(i), s.substring(map.get(ps).length()));
                if(res)
                    return true;
                
            }
            else if(!map.containsKey(ps)){
                for(int j = 1; j <= p.length(); j++){
                    String ss = s.substring(0, j);
                    map.put(ps, ss);
                    boolean res = match(p.substring(i), s.substring(j));
                    if(res) return true;
                    map.remove(ps);
                }
            }
        }
        return false;
    }
}