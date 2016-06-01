/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;
        ListNode h1 = new ListNode(0); // >
        ListNode h2 = new ListNode(0); // =
        ListNode h3 = new ListNode(0); // <
        
        ListNode cur1 = h1;
        ListNode cur2 = h2;
        ListNode cur3 = h3;
        ListNode cur = head;
        
        while(cur != null){
            if(x > cur.val){
                h1.next = cur;
                cur1 = cur1.next;
            }
            else if(x == cur.val){
                h2.next = cur;
                cur2 = cur2.next;
            }
            else{
                h3.next = cur;
                cur3 = cur3.next;
            }
            cur = cur.next;
        }
        
        cur3.next = h2.next;
        cur2.next = h1.next;
        cur1.next = null;
        
        return h3.next;
    }
}