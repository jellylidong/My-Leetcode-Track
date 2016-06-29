public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> toVisit = new LinkedList<>();
        genNext(beginWord, toVisit, wordList);
        wordList.add(endWord);
        
        int step = 2;
        while(!toVisit.isEmpty()){
            int size = toVisit.size();
            for(int i = 0; i < size; i++){
                String cur = toVisit.poll();
                if(cur.equals(endWord))
                    return step;
                else
                    genNext(cur, toVisit, wordList);
            }
            step++;
        }
        
        return 0;
    }
    
    public void genNext(String s, Queue<String> toVisit, Set<String> wordList){
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++){
            char pre = cs[i];
            for(char c = 'a'; c <= 'z'; c++){
                cs[i] = c;
                String newStr = new String(cs);
                if(wordList.contains(newStr)){
                    toVisit.offer(newStr);
                    wordList.remove(newStr);
                }
            }
            cs[i] = pre;
        }
    }
}