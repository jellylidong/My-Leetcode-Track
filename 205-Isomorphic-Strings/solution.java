public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl != tl)
            return false;
        
        return encoding(s).equals(encoding(t));
        
        
        
    }
    
    public String encoding(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res =  new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
            }
            else{
                map.put(c, i);
            }
            res.append(map.get(c));
        }
        
        return res.toString();
    }
}