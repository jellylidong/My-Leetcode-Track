public class MovingAverage {

    /** Initialize your data structure here. */
    int count;
    int size;
    int sum;
    int[] buffer;
    int id;
    public MovingAverage(int size) {
        count = 0;
        this.size = size;
        sum = 0;
        buffer = new int[size];
        id = 0;
    }
    
    public double next(int val) {
        count++;
        id = count%size - 1;
        sum = sum - buffer[id] + val;
        buffer[id] = val;
        return (double)sum/(count < size? (double)count: (double)size);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */