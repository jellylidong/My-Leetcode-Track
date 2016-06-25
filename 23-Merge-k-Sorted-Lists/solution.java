/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public ListNode mergeKLists(ListNode[] lists) {
    //     ListNode helper = new ListNode(0);
    //     ListNode head = helper;
        
        
    //     while(true){
    //         int min = Integer.MAX_VALUE;
    //         int minId = 0;
    //         int nullCount = 0;
    //         for(int i = 0; i < lists.length; i++){
    //             ListNode cur = lists[i];
    //             if(cur != null){
    //                 if(cur.val <= min){
    //                     min = cur.val;
    //                     minId = i;
    //                 }
    //             }
    //             else
    //                 nullCount++;
    //         }
    //         if(nullCount == lists.length)
    //             break;
    //         else{
    //             head.next = lists[minId];
    //             head = head.next;
    //             lists[minId] = lists[minId].next;
    //         }
    //     }
        
    //     return helper.next;
    // }
    
    
    //the above code scans all k lists every time, very low efficiency
    //1. instead,  we can first merge every two lists of lists, name the results res
    //2.then merge every two lists of res,
    //3.repeat 1 and 2 until all only one list left
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        int lo = 0;
        int hi = lists.length-1;
        
        while(lo < hi){
            int ll = lo;
            int hh = hi;
            
            while(ll < hh){
                mergeTwoLists(lists, ll, hh);
                ll++;
                hh--;
            }
            
            hi = lo + (hi-lo)/2;
        }
        return lists[0];
    }
    
    public void mergeTwoLists(ListNode[] lists, int lo, int hi){
        if(lo == hi)
            return;
        else{
            ListNode head = new ListNode(0);
            ListNode cur = head;
            while(lists[lo] != null && lists[hi] != null){
                if(lists[lo].val <= lists[hi].val){
                    cur.next = lists[lo];
                    lists[lo] = lists[lo].next;
                }
                else{
                    cur.next = lists[hi];
                    lists[hi] = lists[hi].next;
                }
                cur = cur.next;
            }
            while(lists[lo] != null){
                cur.next = lists[lo];
                lists[lo] = lists[lo].next;
                cur = cur.next;
            }
            while(lists[hi] != null){
                cur.next = lists[hi];
                lists[hi] = lists[hi].next;
                cur = cur.next;
            }
            lists[lo] = head.next;
        }
    }
}