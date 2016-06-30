public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        Union union = new Union(m, n);
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int[] p: positions){
            int i1 = p[0];
            int j1 = p[1];
            union.add(i1, j1);
            for(int[] d: dir){
                int i2 = i1+d[0];
                int j2 = j1+d[1];
                if(union.isValid(i2,j2) && union.map.containsKey(i2*n+j2) && !union.isCnted(i1,j1, i2,j2))
                    union.connect(i1,j1, i2,j2);
            }
            ans.add(union.size);
        }

        return ans;
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
                int father = map.get(map.get(p)); //p's father's fathers
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