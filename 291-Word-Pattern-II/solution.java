public class Solution {
    HashMap<String, String> map;
    HashSet<String> valSet;
    public boolean wordPatternMatch(String pattern, String str) {
        map = new HashMap<>();
        valSet = new HashSet<>(); 
        //used to store values
        //different chars must be map to different strs, ie if a->s1, then b->s1 is invalid
        
        // map.put("", "");
        char[] cs = pattern.toCharArray();
        return match(cs, 0, str);
        // for(String key:map.keySet())
            // System.out.println(key + " " + map.get(key));
            
        // return res;
    }
    
    public boolean match(char[] cs, int i, String s){
        
        // if(cs.length == 0 && s.length() != 0)
        //     return false;
            
        if(i == cs.length)
            return s.length() == 0;
        
        if(cs.length-i > s.length())
            return false;
        
        // if(map.containsKey(p) && map.get(p).equals(s))
        //     return true;
        
        String ps = "" + cs[i];
        if(map.containsKey(ps) && s.startsWith(map.get(ps))){
            return match(cs, i+1, s.substring(map.get(ps).length()));
        }
        else if(!map.containsKey(ps)){
            for(int j = 1; j <= s.length(); j++){
                String ss = s.substring(0, j);
                if(valSet.contains(ss))
                    continue;
                map.put(ps, ss);
                valSet.add(ss);
                boolean res = match(cs, i+1, s.substring(j));
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