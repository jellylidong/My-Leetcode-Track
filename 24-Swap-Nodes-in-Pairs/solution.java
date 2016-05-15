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
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;
        ListNode cur2 = head;
        
        while(head != null){
            if(cur.next != null){
                cur2 = cur.next;
                cur.next = cur2.next;
                cur2.next = cur;
                pre.next = cur2;
                pre = cur;
            }
            else
                break;
        }
        
        return helper.next;
    }
}