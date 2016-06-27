/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null)
            sb.append("null,");
        else{
            sb.append(root.val+",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;
        Queue<String> q = new LinkedList<>();
        String[] ss = data.split(",");
        for(String s: ss)
            q.offer(s);
        return buildTree(q);
    }
    
    public TreeNode buildTree(Queue<String> q){
            String str = q.poll();
            if(str.equals("null"))
                return null;
            else{
                TreeNode root = new TreeNode(Integer.parseInt(str));
                root.left = buildTree(q);
                root.right = buildTree(q);
                return root;
            }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));