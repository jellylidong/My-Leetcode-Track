public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String newStr = new String(cs);
            if(!map.containsKey(newStr))
                map.put(newStr, new ArrayList<String>());
            map.get(newStr).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}