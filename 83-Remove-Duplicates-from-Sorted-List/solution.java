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
            while(cur != null && cur.next != null && cur.next.val == cur.val)
                cur = cur.next;
            pre.next = cur;
            pre = cur;
        }
        
        return helper.next;
    }
}