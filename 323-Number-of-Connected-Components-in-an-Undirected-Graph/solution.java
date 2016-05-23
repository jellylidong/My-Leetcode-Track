public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++)
            roots[i] = i;
            
        for(int[] edge: edges){
            int n1 = find(roots, edge[0]);
            int n2 = find(roots, edge[1]);
            if(n1 != n2){
                roots[n1] = n2;
                n--;
            }
        }
        
        return n;
    }
    
    public int find(int[] roots, int id){
        while(roots[id] != id)
            id = roots[id];
            
        return id;
    }
}