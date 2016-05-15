/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        
        ListNode cur = head;
        ListNode pre = head;
        
        while(cur != null){
            while(cur != null && cur.val == pre.val)
                cur = cur.next;
            if(pre != cur){
                pre.next = cur;
                pre = cur;
            }
            
            cur = cur.next;
                
        }
        
        return helper.next;
    }
}