/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        
        int carry = 0;
        while(l1 != null && l2 != null){
            int n1 = l1.val;
            int n2 = l2.val;
            int sum = carry + n1 + n2;
            pre.next = new ListNode(sum%10);
            carry = sum / 10;
            
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }
        
        while(l1 != null){
            int sum = l1.val + carry;
            pre.next = new ListNode(sum%10);
            carry = sum / 10;
            
            l1 = l1.next;
            pre = pre.next;
        }
        
        while(l2 != null){
            int sum = l2.val + carry;
            pre.next = new ListNode(sum%10);
            carry = sum / 10;
            
            l2 = l2.next;
            pre = pre.next;
        }
        
        if(carry != 0)
            pre.next = new ListNode(carry);
            
        return helper.next;
        
    }
}