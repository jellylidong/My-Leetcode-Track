public class LRUCache {

    node cur;
    node head;
    int capacity;
    int count;
    HashMap<Integer, node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.cur = new node(-1, -1);
        head = cur;
        this.map = new HashMap<>();

    }

    public int get(int key) {
        if(map.containsKey(key)){
            node curNode = map.get(key);
            node pre = curNode.pre;
            node next = curNode.next;
            pre.next = next;
            if(next != null)
                next.pre = pre;
            cur.next = curNode;
            curNode.pre = cur;
            curNode.next = null;
            cur = curNode;
            return curNode.val;
        }
        else
            return -1;
    }

    public void set(int key, int value) {
        int n = get(key);
        if(n == -1){
            if(count == capacity){
                node next = head.next;
                head.next = next.next;
                if(next.next != null)
                    next.next.pre = head;
                else
                    cur = head;
                count--;
                map.remove(next.key);
            }
            node newNode = new node(key, value);
            cur.next = newNode;
            newNode.pre = cur;
            cur = newNode;
            map.put(key, newNode);
            count++;
        }
        else{
            map.get(key).val = value;
        }
    }

    public void print(){
        node n = head;
        while(n != null) {
            System.out.print(n.val + "+" + n.key + ", ");
            n = n.next;
        }
        System.out.println();
    }

    public class node{
        node pre;
        node next;
        int key; //use val to find key
        int val;
        node(int key, int val){
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
}