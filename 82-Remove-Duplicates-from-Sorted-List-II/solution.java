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
            return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        ListNode next = head.next;
        
        while(next != null){
           if(cur.val == next.val){
               while(next != null && cur.val == next.val)
                    next = next.next;
                pre.next = next;
                cur = next;
           }
           else{
               pre = cur;
               cur = next;
            //   next = next.next;
           }
           if(next != null)
                next = next.next;
        }
        
        return helper.next;
    }
}