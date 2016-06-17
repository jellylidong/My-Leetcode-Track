public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(words.length == 0)
            return ans;
        HashMap<String, Integer> ws = new HashMap<>();
        int wordCount = 0;
        for(String ss: words){
            if(ws.containsKey(ss))
                ws.put(ss, ws.get(ss) + 1);
            else
                ws.put(ss, 1);
            wordCount++;
        }
        int len = words[0].length();
        for(int i = 0; i <= s.length()-len; ){
            String cur = s.substring(i, i+len);
            if(ws.containsKey(cur)){
                int curCount = 0;
                HashMap<String, Integer> used = new HashMap<>();
                used.put(cur, 1);
                curCount++;
                for(int j = i+len; j <= s.length()-len;){
                    String curStr = s.substring(j, j+len);
                    if(!used.containsKey(curStr) && ws.containsKey(curStr)){
                        used.put(curStr, 1);
                        j += len;
                        curCount++;
                    }
                    else if(used.containsKey(curStr) && used.get(curStr) < ws.get(curStr)){
                        used.put(curStr, used.get(curStr) + 1);
                        j += len;
                        curCount++;
                    }
                    else{
                        break;
                    }
                }
                if(curCount == wordCount){
                    ans.add(i);
                    i ++;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }
        
        return ans;
    }
}