/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        int  countA = 0;
        int  countB = 0;
        
        while(curA != curB && curA != null && curB != null){
            curA = curA.next;
            curB = curB.next;
            if(curA == null && curB == null)
                return null;
            if(curA == null){
                if(countA % 2 == 0)
                    curA = headB;
                else
                    curA = headA;
                countA = (countA+1)%2;
            }
            if(curB == null){
                if(countB % 2 == 0)
                    curB = headA;
                else
                    curB = headB;
                countB = (countB+1)%2;
            }
        }
        
        return  curA;
    }
}