/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // ListNode helper = new ListNode(0);
        // helper.next = head;
        // ListNode pre = helper;
        // ListNode cur = head;
        
        // while(cur != null){
        //     ListNode next = cur.next;
        //     if(next == null)
        //         break;
        //     pre.next = next;
        //     cur.next = next.next;
        //     next.next = cur;
        //     pre = cur;
        //     cur = cur.next;
        // }
        
        // return helper.next;
        
        //just type again
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode cur = head;
        ListNode pre = helper;
        
        while(cur != null){
            ListNode next = cur.next;
            if(next != null){
                cur.next = next.next;
                pre.next = next;
                next.next = cur;
                pre = cur;
                cur = cur.next;
            }
            else
                break;
        }
        
        return helper.next;
    }
}