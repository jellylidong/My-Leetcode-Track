public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i <= s.length()-10; i++){
            String sub = s.substring(i, i+10);
            if(map.containsKey(sub)){
                int id = map.get(sub);
                
                    set.add(sub);
                
            }
            else
                map.put(sub, i);
                
            
        }
        
        return new ArrayList<String>(set);
    }
}