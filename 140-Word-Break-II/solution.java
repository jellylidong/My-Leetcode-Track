public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<>();
        // for(int i = s.length()-1; i >= 0; i--){
        //     if(wordDict.contains(s.substring(i)))
        //         break;
        //     else{
        //         if(i == 0)
        //             return list;
        //     }
        // }
        
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
    
    // public List<String> wordBreak(String s, Set<String> wordDict, int max){
        
    // }
    
    //the above code will get LTE
    //https://leetcode.com/discuss/91894/java-6ms-simple-solution-beating-88%25
    //to save time, we can do two things
    //first, find the max word length in dictionary,
    //then for each sub wordbreak, we start from i = 0; if when i = maxLen we still can't find word in the dict
    //we can stop search
    //second, store the start index and the list with this index into hashmap
    //for example, in substring s1, we find we substring at j, then map.put(j, j's list)
    //then if in another substirng s2, if we find substring at j again, we don't need to recurse into further level
    //we can find it from the map
    //this saves a lot time
    
}