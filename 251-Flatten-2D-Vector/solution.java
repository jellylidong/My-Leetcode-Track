public class Vector2D implements Iterator<Integer> {
    List<Integer> list;
    int count = 0;
    public Vector2D(List<List<Integer>> vec2d) {
        list = new ArrayList<>();
        for(List<Integer> curList: vec2d){
            for(Integer n: curList){
                list.add(n);
            }
        }
    }

    @Override
    public Integer next() {
        if(!hasNext())
            return null;
        else
            return list.get(count++);
    }

    @Override
    public boolean hasNext() {
        return count < list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */