/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode helper = new ListNode(Integer.MIN_VALUE);
        helper.next = head;
        ListNode cur =head.next;
        ListNode pre = head;
        
        while(cur != null){
            if(cur.val < pre.val){
                ListNode tmpPre = helper;
                ListNode tmpCur = tmpPre.next;
                while(tmpCur.val < cur.val){
                    tmpPre = tmpCur;
                    tmpCur = tmpCur.next;
                }
                pre.next = cur.next;
                tmpPre.next = cur;
                cur.next = tmpCur;
                cur = pre.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        
        return helper.next;
    }
}