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
        
        while(cur != null){
            head = next;
            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            cur = next;
        }
        
        return head;
    }
}