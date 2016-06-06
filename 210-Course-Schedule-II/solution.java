public class Solution {
    public int[] findOrder(int num, int[][] req) {
        int[] ans = new int[num];
        int[] in = new int[num];
        List[] graph = new List[num];
        for(int i = 0; i < num; i++)
            graph[i] = new ArrayList<Integer>();
        
        for(int[] cs: req){
            in[cs[0]]++;
            graph[cs[1]].add(cs[0]);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < num; i++){
            if(in[i] == 0)
                q.add(i);
        }
        
        int curId = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            ans[curId] = n;
            curId++;
            for(Object c: graph[n]){
                int id = (int)c;
                in[id]--;
                if(in[id] == 0)
                    q.offer(id);
            }
        }
        
        return curId == num? ans: new int[0];
    }
}