/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //split list int two part and merge sort the two sublist recursively
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        if(head != null && head.next == null)
            return head;
            
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre  = head;
        
        while(fast != null){
            pre = slow;
            slow = slow.next;
            
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
        }
        pre.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    pre.next =l1;
                    pre = pre.next;
                    l1 = l1.next;
                }
                else{
                    pre.next = l2;
                    pre = pre.next;
                    l2 = l2.next;
                }
            }
            else{
                while(l1 != null){
                    pre.next = l1;
                    pre = pre.next;
                    l1 = l1.next;
                }
                while(l2 != null){
                    pre.next= l2;
                    pre = pre.next;
                    l2 = l2.next;
                }
            }
        }
        
        return helper.next;
    }
}