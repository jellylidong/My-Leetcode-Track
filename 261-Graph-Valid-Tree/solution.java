public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int len = edges.length;
        if(len == 0)
            return n <= 1;
            
        //note, there are n node so we need to declare a n length array, not edges.length array    
        int[] root = new int[n];
        Arrays.fill(root, -1);
        
        for(int[] e: edges){
            int r1 = find(e[0], root);
            int r2 = find(e[1], root);
            
            // System.out.println(r1 + " " + r2);
            
            if(r1 == r2)
                return false;
            root[r1] = r2;
        }
        
        return n-1 == len;
        
    }
    
    public int find(int i, int[] root){
        if(root[i] == -1)
            return i;
            
        return find(root[i], root);
    }
}