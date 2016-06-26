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
        RandomListNode cur = head;
        
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        
        cur = head;
        while(cur != null){
            RandomListNode node = cur.next;
            node.random = (cur.random == null)? null: cur.random.next;
            cur = cur.next.next;
        }
        
        RandomListNode helper = new RandomListNode(0);
        cur = helper;
        
        while(head != null){
            cur.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cur = cur.next;
        }
        
        return helper.next;
    }
}