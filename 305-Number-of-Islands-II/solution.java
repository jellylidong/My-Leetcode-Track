public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        Union union = new Union(m, n);
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int[] p: positions){
            int i = p[0];
            int j = p[1];
            int p0 = union.transPosition(i, j);
            union.add(i, j);
            for(int[] d: dir){
                int i1 = i+d[0];
                int j1 = j+d[1];
                int p1 = union.transPosition(i1, j1);
                if(p1 >= 0 && union.map.containsKey(p1) && !union.isCnted(p0, p1)){
                    union.connect(p0, p1);
                }
            }
            ans.add(union.size);
        }
        return ans;
    }
    
    public class Union{
        int size;
        int m, n;
        //n is board width ie grid[0].length
        HashMap<Integer, Integer> map; 
        // key-value is child-fater, positon (i, j) is at position i*n+j
        //position -1 will be used to indicate invalid position
        
        Union(int m, int n){
            this.m = m;
            this.n = n;
            this.size = 0;
            //m, n  will be used for calculating valid positions
            map = new HashMap<>();
        }
        
        public void add(int i, int j){
            int p = transPosition(i, j);
            if(p != -2){
                map.put(p, p);
                size++;
            }
        }
        
        public int transPosition(int i, int j){ // transform (i, j) to i*n+j
            if(i < 0 || i >= m || j < 0 || j >= n)
                return -2; //invalid position
            else
                return i*n+j;
        }
        
        public boolean isCnted(int p1, int p2){
            return root(p1) == root(p2);
        }
        
        public int root(int p){
            while(p != map.get(p)){
                int father = map.get(map.get(p));//p's father's father
                map.put(p, father);
                p = map.get(p);
            }
            return p;
        }
        
        public void connect(int p1, int p2){
            int r1 = root(p1);
            int r2 = root(p2);
            if(r1 > r2){
                map.put(r2, r1);
            }
            else{
                map.put(r1, r2);
            }
            size--;
        }
    }
}