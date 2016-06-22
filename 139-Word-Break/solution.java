public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        
        q.offer(0);
        
        while(!q.isEmpty()){
            int start = q.poll();
            if(start == s.length())
                return true;
                
            for(String str: wordDict){
                if(s.substring(start, start+str.length()).equals(str)){
                    if(!visited.contains(start+str.length())){
                        q.offer(start+str.length());
                        visited.add(start+str.length());
                    }
                }
            }
        }
        
        return false;
    }
}