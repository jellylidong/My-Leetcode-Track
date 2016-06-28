public class Logger {

/**
HashMap<Integer, HashSet<String>> map;
    Queue<Integer> q;
    public Logger() {
        map = new HashMap<>();    
        q = new LinkedList<>();
    }
    
    /
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!q.isEmpty() && q.peek() == timestamp){
            if(map.get(timestamp).contains(message))
                return false;
        }
        q.offer(timestamp);
        while(!q.isEmpty() && q.peek() + 10 < timestamp){
            map.remove(q.poll());
        }
        for(int i = 1; i < 10; i++){
            if(timestamp-i >= q.peek() && map.containsKey(timestamp-i) && map.get(timestamp-i).contains(message))
                return false;
        }
        // map.put(timestamp, message);
        if(!map.containsKey(timestamp))
            map.put(timestamp, new HashSet<String>());
        map.get(timestamp).add(message);
        
        return true;
    }
**/

//above code works and saves space, but slows down the performance when clearing the space
    /** Initialize your data structure here. */
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }
        else{
            if(timestamp >= map.get(message)+10){
                map.put(message, timestamp);
                return true;
            }
            else
                return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */