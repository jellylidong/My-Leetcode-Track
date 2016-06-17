public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(words.length == 0)
            return ans;
            
        int len = words[0].length();
        HashMap<String, Integer> ws = new HashMap<>();
        
        for(String ss: words){
            if(ws.containsKey(ss))
                ws.put(ss, ws.get(ss) + 1);
            else
                ws.put(ss, 1);
        }
        
        for(int i = 0; i < len; i++){
            int count = 0;
            HashMap<String, Integer> used = new HashMap<>();
            int left = i;
            for(int j = i; j <= s.length()-len; j+=len){
                String str = s.substring(j, j+len);
                if(ws.containsKey(str)){
                    if(!used.containsKey(str) || used.get(str) < ws.get(str)){
                        used.put(str, used.containsKey(str)? used.get(str)+1: 1);
                        count++;
                    }
                    else{
                        String cur = s.substring(left, left+len);
                        while(used.get(cur) == ws.get(cur)){
                            used.put(cur, used.get(cur) - 1);
                            count--;
                            left += len;
                            cur = s.substring(left, left+len);
                        }
                        used.put(str, used.get(str)+1);
                        count++;
                    }
                    if(count == words.length){
                        ans.add(left);
                    }
                }
                else{
                    left += len;
                }
            }
        }
        
        return ans;
    }
}