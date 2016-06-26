public class LRUCache {
    int cap;
    int size;
    node head;
    node tail;
    HashMap<Integer, node> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.head = new node(-1, -1);
        this.tail = new node(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        node cur = map.get(key);
        node pre = cur.pre;
        node next = cur.next;
        if(next.val != -1){
            pre.next = next;
            next.pre = pre;
            
            cur.pre = tail.pre;
            tail.pre.next = cur;
            cur.next = tail;
            tail.pre = cur;
        }
        return cur.val;
        
    }
    
    public void set(int key, int value) {
        int curVal = get(key);
        if(curVal == -1){
            node newNode = new node(key, value);
            newNode.pre = tail.pre;
            tail.pre.next = newNode;
            newNode.next = tail;
            tail.pre = newNode;
            
            map.put(key, newNode);
            
            size++;
            if(size > cap){
                node toRm = head.next;
                map.remove(toRm.key);
                head.next = head.next.next;
                head.next.pre = head;
                size--;
            }
        }
        else{
            map.get(key).val = value;
        }
    }
    
    public class node{
        node pre;
        node next;
        int val;
        int key;
        node(int key, int val){
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }
}