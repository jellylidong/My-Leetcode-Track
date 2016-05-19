/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        
        ListNode pre = null;
        ListNode next = head;
        cur = head;
        for(int i = 0; i < len/2; i++){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(len%2 == 1)
            cur = cur.next;
        while(cur != null && pre != null){
            if(cur.val != pre.val)
                return false;
            cur = cur.next;
            pre = pre.next;
        }
        
        return true;
    }
}