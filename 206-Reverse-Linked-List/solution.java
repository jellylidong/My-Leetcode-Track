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
        
        while(cur != null){
           next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
        }
        
        return pre;
    }
}