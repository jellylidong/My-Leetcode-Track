/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 /*explain
 assume there are l nodes before circle, and there are c nodes in the circle
 slow goes one node each step, fast goes two node each step
 after p steps they meet
 then (p-l)%c == (2p-l)%c
 because they are in the same position of the circle
 (2p-l)%c = p%c + (p-l)%c == (p-l)%c ==> p%c == 0;
 so (p-l)%c = (-l)%c, which means current position is l nodes from the beginning
 node:don't worry about l  > c or l < c, actually, no matter what l is has nothing to do with the beginning
 position of the circle, so we can simply assume the l < c.
 
 so after slow and fast meet
 set slow to head, let each pointer go on node each step
 then the meet node is the starting node of the circle
 i.e the two pointers both goes l nodes
 */
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast == null)
                return null;
            fast = fast.next;
            if(slow == fast)
                break;
        }
        if(fast == null)
                return null;
                
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
        
    }
}