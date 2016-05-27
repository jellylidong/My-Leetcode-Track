/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeLinkNode pre = null;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeLinkNode cur = q.poll();
                if(cur.right != null)
                    q.offer(cur.right);
                if(cur.left != null)
                    q.offer(cur.left);
                cur.next = pre;
                pre = cur;
            }
        }
    }
}