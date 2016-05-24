/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode cur = head;
        if(cur == null)
            return null;
        ListNode odd = head;
        ListNode curOdd = odd;
        ListNode even = head.next;
        ListNode curEven = even;
        if(even == null)
            return odd;
            
        cur = cur.next.next;
        while(cur != null){
            curOdd.next = cur;
            curOdd = curOdd.next;
            cur = cur.next;
            if(cur != null){
                curEven.next = cur;
                curEven = curEven.next;
                cur = cur.next;
            }
            else{
                curEven.next = null;
            }
        }
        
        curOdd.next = even;
        return odd;
    }
}