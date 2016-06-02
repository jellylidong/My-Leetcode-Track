/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        
        ListNode preTail = helper;
        ListNode cur = head;
        
        for(int i = 1; i < m; i++){
            preTail = cur;
            cur = cur.next;
        }
        
        ListNode postTail = cur;
        
        ListNode next = null;
        ListNode pre = null;
        
        //note: to reverse a linkedlist with length Len
        //we must rever Len times, Not len-1 times
        for(int i = m; i <= n; i++){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        preTail.next = pre; //pre is the head of ther reverse part
        if(postTail != null)
            postTail.next = cur; // cur is the head of the right un reversed part
        
        return helper.next;
        
            
        
    }
}