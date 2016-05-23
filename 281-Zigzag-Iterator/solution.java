public class ZigzagIterator {

    int count;
    int i1;
    int i2;
    List<Integer> v1;
    List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        count = 0;
        i1 = 0;
        i2 = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        int res = 0;
        if(i1 < v1.size() && i2 < v2.size()){
            if(count%2 == 0){
                res = v1.get(i1);
                i1++;
                count = (count+1)%2;
            }
            else{
                res = v2.get(i2);
                i2++;
                count = (count+1)%2;
            }
        }
        else{
            if(i1 < v1.size())
                res = v1.get(i1++);
            if(i2 < v2.size())
                res = v2.get(i2++);
        }
        
        return res;
    }

    public boolean hasNext() {
        return i1 < v1.size() || i2 < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */