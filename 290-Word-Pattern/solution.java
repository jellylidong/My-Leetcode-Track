public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String code1 = encoding(pattern);
        
        String[] ss = str.split(" ");
        String code2 = encoding(ss);
        
        return code1.equals(code2);
    }
    
    public String encoding(String s){
        StringBuilder code = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c, i);
            code.append(map.get(c));
        }
        
        return code.toString();
    }
    
    public String encoding(String[] ss){
        StringBuilder code = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < ss.length; i++){
            if(!map.containsKey(ss[i]))
                map.put(ss[i], i);
            code.append(map.get(ss[i]));
        }
        
        return code.toString();
    }
}