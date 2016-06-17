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
                    used.put(str, used.containsKey(str)? used.get(str)+1: 1);
                    //first put words into used, then we decide if the words we put in is valid
                    
                    //valid put, so count++;
                    if(used.get(str) <= ws.get(str)){
                        count++;
                    }
                    
                    //invalid put, note the count value does not include the invalid put
                    else{//we put more words into used than ws, 
                         // so we need to remove words from left until there're no more words
                        
                        while(used.get(str) > ws.get(str)){
                            String tmp = s.substring(left, left+len);
                            used.put(tmp, used.get(tmp)-1);
                            
                            //note here, since we have a invalid put, that is to say
                            //for example used is ("a", 2), ws is ("a", 1)
                            //after we reduce 1 , used becomes ("a", 1)
                            //in this case, it means we just remove the invalidly put word,
                            //since the count does not include the invalid put, so this case count should not be reduce 1
                            /*
                            "barfoofoobarthefoobarman"
                            ["bar","foo","the"]
                            */
                            if(used.get(tmp) < ws.get(tmp))
                                count--;
                            if(used.get(tmp) == 0)
                                used.remove(tmp);
                        
                            left += len;
                            
                        }
                    }
                        
                    if(count == words.length){
                        
                        ans.add(left);
                        String tmp = s.substring(left, left+len);
                        used.put(tmp, used.get(tmp)-1);
                        if(used.get(tmp) == 0)
                            used.remove(tmp);
                        left += len;
                        count--;
                       
                    }
                }
                else{
                    used = new HashMap<>();
                    count = 0;
                    left = j+len;
                }
            }
        }
        
        return ans;
    }
}