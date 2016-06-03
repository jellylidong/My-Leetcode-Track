public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> keys = new ArrayList<>();
        for(String s: strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if(map.containsKey(key))
                map.get(key).add(s);
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                keys.add(key);
                map.put(key, list);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key: keys){
            ans.add(map.get(key));
        }
        
        return ans;
        
        
    }
}