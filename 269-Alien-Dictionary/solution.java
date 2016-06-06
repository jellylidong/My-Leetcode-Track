public class Solution {
    public String alienOrder(String[] words) {
        //the tricky part of this problem is to build graph egds [char a, char b], ie a is after b
        //once graph is built up, we can use dfs or bfs topology sort
        
        HashSet<Character> charSet = new HashSet<>();
        for(String s: words){
            for(int i = 0; i < s.length(); i++)
                charSet.add(s.charAt(i));
        }
        
        //init graph
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for(char c: charSet)
            graph.put(c, new ArrayList<>());
            
        //build graph
        for(int i = 0; i < words.length-1; i++){
            for(int j = i+1; j < words.length; j++){
                for(int k = 0; k < Math.min(words[i].length(), words[j].length()); k++){
                    char ci = words[i].charAt(k);
                    char cj = words[j].charAt(k);
                    
                    if(ci != cj){
                        // cj is after ci
                        if(!graph.get(ci).contains(cj))
                            graph.get(ci).add(cj);
                        break;
                    }
                }
            }
        }
        
        HashSet<Character> alreadyAdded = new HashSet<Character>();
        HashMap<Character, Boolean> visited = new HashMap<>();
        for(char c: charSet)
            visited.put(c, false);
        StringBuilder sb = new StringBuilder();
        
        for(char c: charSet){
            if(!dfs(c, graph, visited, alreadyAdded, sb))
                return "";
        }
        
        return sb.reverse().toString();
    }
    
    public boolean dfs(char c, HashMap<Character, List<Character>> graph, HashMap<Character, Boolean> visited, HashSet<Character> alreadyAdded, StringBuilder sb){
        if(visited.get(c))
            return false;
            
        // if(graph.get(c).size() == 0){
        //     if(!alreadyAdded.contains(c)){
        //         alreadyAdded.add(c);
        //         sb.append(c);
        //     }
        //     return true;
        // }
        else{
            visited.put(c, true);
            for(char cur: graph.get(c)){
                if(!dfs(cur, graph, visited, alreadyAdded, sb))
                    return false;
            }
            if(!alreadyAdded.contains(c)){
                alreadyAdded.add(c);
                sb.append(c);
            }
            visited.put(c, false);
        }
        return true;   
    }
}