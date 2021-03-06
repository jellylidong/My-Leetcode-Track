public class Solution {
    
    //snapt chat OA, use BFS is faster
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        if(s.length() == 0){
            if(wordDict.contains(s))
                return true;
            else
                return false;
        }
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        
        q.offer(0);
        
        //BFS by traersing wordDict
        // while(!q.isEmpty()){
        //     int start = q.poll();
        //     if(start == s.length())
        //         return true;
                
        //     for(String str: wordDict){
        //         if(start+str.length() <= s.length() && s.substring(start, start+str.length()).equals(str)){
        //             if(!visited.contains(start+str.length())){
        //                 q.offer(start+str.length());
        //                 visited.add(start+str.length());
        //             }
        //         }
        //     }
        // }
        
        //BFS by traversing s, both are OK, but in leetcode testcases, traversing wordDict is faster
        while(!q.isEmpty()){
            int start = q.poll();
            if(start == s.length())
                return true;
                
            for(int i = start+1; i <= s.length(); i++){
                String str = s.substring(start, i);
                if(wordDict.contains(str) && !visited.contains(i)){
                    q.offer(i);
                    visited.add(i);
                }
            }
        }
        
        return false;
    }
}