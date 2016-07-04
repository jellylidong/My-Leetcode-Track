public class Solution {
        public String alienOrder(String[] words) {
        HashSet<Character> charSet = new HashSet<>();
        genCharSet(charSet, words);
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>(); //key: char, value:chars after key (in alien order)
        initGraph(charSet, graph);
        buildGraph(graph, words);
        StringBuilder sb = new StringBuilder();
        // print(graph);
        BFS(graph, sb);
        return sb.toString();
    }

    public void genCharSet(HashSet<Character> charSet, String[] words){
        for(String s:words){
            for(int i = 0; i < s.length(); i++){
                charSet.add(s.charAt(i));
            }
        }
    }

    public void initGraph(HashSet<Character> charSet, HashMap<Character, ArrayList<Character>> graph){
        for(char c: charSet){
            if(!graph.containsKey(c)){
                graph.put(c, new ArrayList<Character>());
            }
        }
    }

    public void buildGraph(HashMap<Character, ArrayList<Character>> graph, String[] words){
        for(int i = 0; i < words.length-1; i++){
            for(int j = i+1; j < words.length; j++){
                for(int k = 0; k < Math.min(words[i].length(), words[j].length()); k++){
                    char ci = words[i].charAt(k);
                    char cj = words[j].charAt(k);
                    if(ci != cj){
                        if(!graph.get(ci).contains(cj)){
                            graph.get(ci).add(cj);
                            // if(ci == 'f')
                            //     System.out.println(words[i] + " " + words[j]);
                        }
                        break;
                    }
                }
            }
        }
    }

    public void BFS(HashMap<Character, ArrayList<Character>> graph, StringBuilder sb){
        HashMap<Character, Integer> in = new HashMap<>();
        for(char c: graph.keySet()){
            in.put(c, 0);
        }
        for(char c: graph.keySet()){
            for(char cc: graph.get(c)){ //go through all chars after c
                in.put(cc, in.get(cc)+1); //number of chars before cc
            }
        }

        Queue<Character> q = new LinkedList<>();
        HashSet<Character> toRm = new HashSet<>();

        for(char c: in.keySet()){
            if(in.get(c) == 0){
                q.offer(c);
                // toRm.add(c);
            }
        }
        // for(char c:toRm)
        //     in.remove(c);

        while(!q.isEmpty()){
            char c = q.poll();
            sb.append(c);
            for(char cc: graph.get(c)){
                // if(!in.containsKey(cc))
                //     continue;
                in.put(cc, in.get(cc)-1);
                if(in.get(cc) == 0){
                    q.offer(cc);
                    // in.remove(cc);
                }
            }
        }
        
        // System.out.println(sb.length());
        // System.out.println(graph.size());
        
        if(sb.length() != graph.size())    
            sb.delete(0, sb.length());
    }
    
    public void print(HashMap<Character, ArrayList<Character>> graph){
        for(char c: graph.keySet()){
            System.out.print(c+": ");
            for(char cc: graph.get(c))
                System.out.print(cc + " ");
            System.out.println();
        }
    }
    
    //["a","b","a"]
}