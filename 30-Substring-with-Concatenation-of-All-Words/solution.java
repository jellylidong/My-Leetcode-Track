public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(words.length == 0)
            return ans;
        HashSet<String> ws = new HashSet<>();
        for(String ss: words){
            ws.add(ss);
        }
        int len = words[0].length();
        for(int i = 0; i <= s.length()-len; ){
            String cur = s.substring(i, i+len);
            if(ws.contains(cur)){
                HashSet<String> used = new HashSet<>();
                used.add(cur);
                for(int j = i+len; j <= s.length()-len;){
                    String curStr = s.substring(j, j+len);
                    if(!used.contains(curStr) && ws.contains(curStr)){
                        used.add(curStr);
                        j += len;
                    }
                    else{
                        break;
                    }
                }
                if(used.size() == ws.size()){
                    ans.add(i);
                    i += len*used.size();
                }
            }
            else{
                i++;
            }
        }
        
        return ans;
    }
}