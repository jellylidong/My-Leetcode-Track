/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
            
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            if(count%2 == 0){
                for(int i = 0; i < size; i++){
                    TreeNode cur = q.pollFirst();
                    list.add(cur.val);
                    if(cur.left != null)
                        q.offerLast(cur.left);
                    if(cur.right != null)
                        q.offerLast(cur.right);
                }
            }
            else{
                for(int i = 0; i < size; i++){
                    TreeNode cur = q.pollLast();
                    list.add(cur.val);
                    if(cur.right != null)
                        q.offerFirst(cur.right);
                    if(cur.left != null)
                        q.offerFirst(cur.left);
                }
            }
            count = (count+1)%2;
            ans.add(list);
        }
        
        return ans;
    }
}