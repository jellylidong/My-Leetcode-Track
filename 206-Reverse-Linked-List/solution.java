/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
            
        if(head.next == null)
            return head;
            
        // ListNode helper = new ListNode(0);
        // helper.next = head;
        
        ListNode next = head;
        ListNode cur = head;
        ListNode pre = null; 
        //regard the linked list as a circle, with a "null node"
        // pre is the end of the linked list, should be null initially
        
        while(cur != null){
           next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
        }
        
        return pre;
    }
}