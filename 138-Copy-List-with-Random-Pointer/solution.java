/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //step 1: insert a new node after each node n, which has the same value of n
        //step 2: update the random pointer of the inserted node
        //obviously, for the orginal node n, if its random pointer points at node x
        //then for the inserted node after node n, let's call it i, its random pointer should pointe at x.next
        
        //step 3: after above is done, we can get the copied list by extract the very two nodes
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur = cur.next;
            cur.next = next;
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null){
            RandomListNode next = cur.next;
            if(cur.random != null)
                next.random = cur.random.next;
                
            cur = cur.next.next;
        }
        
        RandomListNode helper = new RandomListNode(0);
        RandomListNode pre = helper;
        cur = head;
        while(cur != null){
            RandomListNode next = cur.next.next;
            pre.next = cur.next;
            pre = pre.next;
            
            //recover the original list
            cur.next = next;
            cur = cur.next;
        }
        
        return helper.next;
        
    }
    
    //{-1,#}
}