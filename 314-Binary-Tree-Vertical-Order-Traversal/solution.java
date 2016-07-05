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
    int min = 0;
    int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //instead of using a pair class that contains TreeNode and its level value
        //we can use level order BFS and use a queue to store its level
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        
        int min = 0;
        int max = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        q.offer(root);
        level.offer(0);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                int l = level.poll();
                if(!map.containsKey(l))
                    map.put(l, new ArrayList<Integer>());
                map.get(l).add(cur.val);
                min = Math.min(min, l);
                max = Math.max(max, l);
                if(cur.left != null){
                    q.offer(cur.left);
                    level.offer(l-1);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                    level.offer(l+1);
                }
            }
        }
        
        for(int i = min; i <= max; i++){
            ans.add(map.get(i));
        }
        
        return ans;
    }
    
    
}