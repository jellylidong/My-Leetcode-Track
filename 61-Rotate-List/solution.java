/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
            
        
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        
        k = k%len;
        if(k == 0)
            return head;
        ListNode pre = head;
        cur = head;
        for(int i = 0; i < len-k; i++){
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        ListNode newHead = cur;
        pre = cur;
        while(cur != null){
            pre = cur;
            cur = cur.next;
        }
        pre.next = head;
        return newHead;
    }
}