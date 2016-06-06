public class Solution {
    public boolean canFinish(int num, int[][] req) {
        List[] graph = new List[num];
        for(int i = 0; i < num; i++)
            graph[i] = new ArrayList<Integer>();
        
        boolean[] visited = new boolean[num];
        
        for(int[] cs: req){
            graph[cs[0]].add(cs[1]);
        }
        
        for(int i = 0; i < num; i++){
            if(!dfs(graph, visited, i))
                return false;
        }
        
        return true;
    }
    
    public boolean dfs(List[] graph, boolean[] visited, int n){
        if(visited[n])
            return false;
        visited[n] = true;
        for(int i = 0; i < graph[n].size(); i++){
            if(!dfs(graph, visited, (int)graph[n].get(i)))
                return false;
        }
        visited[n] = false;
        return true;
    }
}