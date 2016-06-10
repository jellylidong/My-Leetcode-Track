public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> dict) {
        Queue<String> toVisit = new LinkedList<>();
        genNext(beginWord, dict, toVisit);
        dict.add(endWord);
        
        int step = 2;
        while(!toVisit.isEmpty()){
            int size = toVisit.size();
            for(int i = 0; i < size; i++){
                String cur = toVisit.poll();
                if(cur.equals(endWord))
                    return step;
                genNext(cur, dict, toVisit);
            }
            step++;
        }
        return 0;
    }
    
    public void genNext(String cur, Set<String> dict, Queue<String> toVisit){
        char[] cs = cur.toCharArray();
        for(int i = 0; i < cs.length; i++){
            char tmp = cs[i];
            for(char c = 'a'; c <= 'z'; c++){
                cs[i] = c;
                String s = new String(cs);
                if(dict.contains(s)){
                    toVisit.offer(s);
                    dict.remove(s);
                }
            }
            cs[i] = tmp;
        }
    }
}