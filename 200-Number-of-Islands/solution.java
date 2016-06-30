public class Solution {
    public int numIslands(char[][] grid) {
        int[][] dir = {{0,-1}, {-1,0}};
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        if(n == 0)
            return 0;
        Union union = new Union(m, n);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    union.add(i, j);
                    for(int[] d: dir){
                        int i1 = i+d[0];
                        int j1 = j+d[1];
                        if(union.isValid(i1,j1) && grid[i1][j1] == '1' && !union.isCnted(i, j, i1, j1))
                            union.connect(i, j, i1, j1);
                    }
                }
            }
        }
        
        return union.size;
    }
    
    public class Union{
        int m, n;
        int size;
        HashMap<Integer, Integer> map; //key-value is child-father

        Union(int m, int n){
            this.m = m;
            this.n = n;
            this.size = 0;
            this.map = new HashMap<>();
        }

        public void add(int i, int j){
            if(isValid(i, j)) {
                map.put(i * n + j, i * n + j);
                size++;
            }
        }

        public boolean isValid(int i, int j){
            return (i >= 0 && i < m) && (j >= 0 && j < n);
        }

        public int root(int i, int j){
            int p = i*n + j;
            while(p != map.get(p)){
                int father = map.get(map.get(p)); //p's father's fathers
                map.put(p, father);
                p = map.get(p); // or p = father
            }
            return p;
        }

        public boolean isCnted(int i1, int j1, int i2, int j2){
            return root(i1, j1) == root(i2, j2);
        }

        public void connect(int i1, int j1, int i2, int j2){
            int p1 = i1*n+j1;
            int p2 = i2*n+j2;

            int r1 = root(i1, j1);
            int r2 = root(i2, j2);
            if(r1 < r2) { //here we assume bigger number is father
                map.put(r1, r2);

            }
            else {
                map.put(r2, r1);

            }
            size--;
        }
    }
}