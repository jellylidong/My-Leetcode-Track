/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
/*
!!!!!!!!!!!!
this problem is also a DFS with a global variable, 
the thought is similar to 114. Flatten Binary Tree to Linked List
change the global variable while dfs
*/
public class Solution {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        node = null;
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        
        node = head;
        return helper(0, len-1);
    }
    
    public TreeNode helper(int lo, int hi){
        if(lo > hi)
            return null;
        
        int mid = lo + (hi-lo)/2;
        TreeNode left = helper(lo, mid-1);
        TreeNode root = new TreeNode(node.val);
        
        node = node.next;
        TreeNode right = helper(mid+1, hi);
        
        root.left = left;
        root.right = right;
        
        return root;
        
    }
}