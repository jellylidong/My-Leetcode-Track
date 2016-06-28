public class Logger {

    /** Initialize your data structure here. */
    
    HashMap<Integer, HashSet<String>> map;
    Queue<Integer> q;
    public Logger() {
        map = new HashMap<>();    
        q = new LinkedList<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
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
}

/*
["Logger","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage"]
[[],[0,"A"],[0,"B"],[0,"C"],[0,"A"],[0,"B"],[0,"C"],[0,"A"],[0,"B"],[0,"C"],[0,"A"]]
*/

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */