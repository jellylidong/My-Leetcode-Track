public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> list;
    int x;
    int y;
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
        x = 0;
        y = 0;
    }

    @Override
    public Integer next() {
        if(!hasNext())
            return null;
        else{
            
            int res = list.get(x).get(y);
            y++;
            
            return res;
        }
    }

    @Override
    public boolean hasNext() {
        while(x < list.size() && y == list.get(x).size()){
                x++;
                y = 0;
            }
        return x < list.size() && y < list.get(x).size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */