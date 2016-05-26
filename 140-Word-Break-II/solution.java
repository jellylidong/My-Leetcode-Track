public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<>();
        for(int i = s.length()-1; i >= 0; i--){
            if(wordDict.contains(s.substring(i)))
                break;
            else{
                if(i == 0)
                    return list;
            }
        }
        
        for(int i = 0; i < s.length(); i++){
            if(wordDict.contains(s.substring(0, i))){
                String head = s.substring(0, i);
                List<String> cur = wordBreak(s.substring(i), wordDict);
                for(String str: cur){
                    list.add(head + " " + str);
                }
            }
        }
        if(wordDict.contains(s))
            list.add(s);
        return list;
    }
}