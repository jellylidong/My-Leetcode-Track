public class Solution {
    // public boolean canFinish(int num, int[][] req) {
    //     List[] graph = new List[num];
    //     for(int i = 0; i < num; i++)
    //         graph[i] = new ArrayList<Integer>();
        
    //     boolean[] visited = new boolean[num];
        
    //     for(int[] cs: req){
    //         graph[cs[0]].add(cs[1]);
    //     }
        
    //     for(int i = 0; i < num; i++){
    //         if(!dfs(graph, visited, i))
    //             return false;
    //     }
        
    //     return true;
    // }
    
    // public boolean dfs(List[] graph, boolean[] visited, int n){
    //     if(visited[n])
    //         return false;
    //     visited[n] = true;
    //     for(int i = 0; i < graph[n].size(); i++){
    //         if(!dfs(graph, visited, (int)graph[n].get(i)))
    //             return false;
    //     }
    //     visited[n] = false;
    //     return true;
    // }
    
    //above code works, but dfs is kind of slow, try bfs
    //find all courses has 0 in-degress, ie this course has no pre-required course
    //store them (what ever you like, order does not matter, here we use queue)
    //iterate them (remove them from the queue) and reduce all their neighbors in-degree by 1
    //if the neighbor's in-degree becomes one, put it to the queue
    
    //repeat above until queue is empty
    //since only 0-in-degree node would be put in the queue
    //so if there is a circle, this circle will never be put in the queue
    //so count the node while removing node from the queue
    //if the count == num, it means no circle, otherwise, there is a circle
    public boolean canFinish(int num, int[][] req) {
        
        List[] graph = new List[num];
        for(int i = 0; i < num; i++)
            graph[i] = new ArrayList<Integer>();// graph[i] means course i 's list of following courses
        int[] in = new int[num]; //in[i] means how many pre-required course does course i has
        
        for(int[] cs: req){
            in[cs[0]]++;
            graph[cs[1]].add(cs[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < num; i++){
            if(in[i] == 0)
                q.offer(i);
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            count++;
            for(Object i: graph[n]){
                in[(int)i]--;
                if(in[(int)i] == 0)
                    q.offer((int)i);
            }
        }
        
        return count == num;
        
    }
}