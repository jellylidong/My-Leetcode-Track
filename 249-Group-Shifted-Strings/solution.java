public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strings){
            String code = encode(s);
            if(map.containsKey(code))
                map.get(code).add(s);
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(code, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list: map.values())
            ans.add(list);
        return ans;
    }
    
    public String encode(String s){
        if(s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        sb.append(0).append(",");
        for(int i= 1; i < s.length(); i++){
            int diff = s.charAt(i) - c;
            if(diff < 0)
                diff += 26;
            sb.append(diff).append(",");
        }
        return sb.toString();
    }
}