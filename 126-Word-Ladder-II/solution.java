public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> dict) {
        HashSet<String> s1 = new HashSet<>();
        HashSet<String> s2 = new HashSet<>();
        
        s1.add(beginWord);
        s2.add(endWord);
        
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        buildGraph(s1, s2, dict, graph, true);
        
        List<List<String>> ans = new ArrayList<>();
        List<String> sol = new ArrayList<>();
        sol.add(beginWord);
        genList(graph, beginWord, endWord, ans, sol);
        
        return ans;
    }
    
    public void buildGraph(HashSet<String> s1, HashSet<String> s2,  Set<String> dict,
                           HashMap<String, ArrayList<String>> graph, boolean genChild){
         if(s1.isEmpty())
            return;
            
         if(s1.size() > s2.size()){
            buildGraph(s2, s1, dict, graph, !genChild);
            return;
         }
         
         dict.removeAll(s1);
         dict.removeAll(s2);
         
         boolean crossed = false;
         
         HashSet<String> newSet = new HashSet<>();//used to store newly generated child or parent
         for(String s: s1){
             char[] cs = s.toCharArray();
             for(int i = 0; i < cs.length; i++){
                 char pre = cs[i];
                 for(char c='a'; c <= 'z'; c++){
                    //  if(c == pre)
                    //     continue;
                    cs[i] = c;
                    String newStr = new String(cs);
                    String key = genChild? s: newStr;
                    String val = genChild? newStr: s;
                    
                    ArrayList<String> list = graph.containsKey(key)? graph.get(key): new ArrayList<String>();
                    
                    
                    if(s2.contains(newStr)){
                        list.add(val);
                        graph.put(key, list);
                        crossed = true;
                    }
                    if(!crossed && dict.contains(newStr)){
                        list.add(val);
                        graph.put(key, list);
                        newSet.add(val);
                    }
                 }
                 cs[i] = pre;
             }
            //  if(crossed)
            //     break;
         }
         
         if(!crossed)
            buildGraph(s2, newSet, dict, graph, !genChild);
    }
    
    public void genList(HashMap<String, ArrayList<String>> graph, String begin, String end, List<List<String>> ans, List<String> sol){
		if(begin.equals(end))
			ans.add(new ArrayList<>(sol));
		else if(graph.containsKey(begin)){
			for(String s: graph.get(begin)){
				sol.add(s);
				genList(graph, s, end, ans, sol);
				sol.remove(sol.size()-1);
			}
		}
	}
}