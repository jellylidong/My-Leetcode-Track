/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        if(len <= 2)
            return;
            
        cur = head;
        ListNode pre = head;
        for(int i = 0; i < len/2; i++){
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        
        ListNode l1 = head;
        ListNode l2 = reverse(cur);
        
        ListNode helper = new ListNode(0);
        cur = helper;
        while(l1 != null && l2 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        if(l2 != null){
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        
        head = helper.next;
        
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}