public class Solution {
    HashMap<String, String> map;
    HashSet<String> valSet;
    public boolean wordPatternMatch(String pattern, String str) {
        map = new HashMap<>();
        valSet = new HashSet<>();
        map.put("", "");
        boolean res = match(pattern, str);
        // for(String key:map.keySet())
            // System.out.println(key + " " + map.get(key));
            
        return res;
    }
    
    public boolean match(String p, String s){
        
        if(p.length() == 0 && s.length() != 0)
            return false;
        if(map.containsKey(p) && map.get(p).equals(s))
            return true;
        
        String ps = p.substring(0, 1);
        if(map.containsKey(ps) && s.startsWith(map.get(ps))){
            boolean res = match(p.substring(1), s.substring(map.get(ps).length()));
            if(res)
                return true;
            
        }
        else if(!map.containsKey(ps)){
            for(int j = 1; j <= s.length(); j++){
                String ss = s.substring(0, j);
                if(valSet.contains(ss))
                    continue;
                map.put(ps, ss);
                valSet.add(ss);
                boolean res = match(p.substring(1), s.substring(j));
                if(res) return true;
                map.remove(ps);
                valSet.remove(ss);
            }
        }
        
        return false;
    }
    
    /*
    "abab"
    "redblueredblue"
    
    
    
    
    */
}