/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode cur = head;
        ListNode pre = helper;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        
        return helper.next;
    }
}