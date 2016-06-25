/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode helper = new ListNode(0);
        ListNode head = helper;
        
        
        while(true){
            int min = Integer.MAX_VALUE;
            int minId = 0;
            int nullCount = 0;
            for(int i = 0; i < lists.length; i++){
                ListNode cur = lists[i];
                if(cur != null){
                    if(cur.val >= min){
                        min = cur.val;
                        minId = i;
                    }
                }
                else
                    nullCount++;
            }
            if(nullCount == lists.length)
                break;
            else{
                head.next = lists[minId];
                head = head.next;
                lists[minId] = lists[minId].next;
            }
        }
        
        return helper.next;
    }
}